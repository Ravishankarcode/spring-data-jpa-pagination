package com.example.datajpa.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.datajpa.model.User;
/**
 * 
 * @author Ravishankar.kumar
 *
 */
@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Integer>{


    // derived queries

    Page<User> findByFirstname(String firstname, Pageable pageable);

    Slice<User> findByAgeBetween(int start, int end, Pageable pageable);

    List<User> findByLastnameIsNotNull(Pageable pageable);

    // custom queries

    @Query("SELECT p FROM User p WHERE p.lastname = ?1")
    Page<User> findByLastnameJPQL(String lastname, Pageable pageable);

    @Query("SELECT p FROM User p WHERE p.age < :age")
    Page<User> findByAgeLessThanJPQL(@Param("age") int page, Pageable pageable);

    // native queries
    
    @Query(value = "SELECT * FROM User p WHERE p.firstname = :firstname",
            countQuery = "SELECT count(*) User p WHERE p.firstname = :firstname",
            nativeQuery = true)
    Page<User> findByFirstnameNativeSQL(@Param("firstname") String firstname, Pageable pageable);

    // named queries

    Page<User> findByFirstnameNamed(String firstname, Pageable pageable);

    @Query(countQuery = "SELECT count(*) User p WHERE p.lastname = :lastname",
            nativeQuery = true)
    Page<User> findByLastnameNativeNamed(@Param("lastname") String lastname, Pageable pageable);
	
}
