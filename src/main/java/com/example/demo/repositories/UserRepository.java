package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {


    @Query(value = """
            select * from users u
            where u.username = :username
            """,nativeQuery = true)
    User getUserByName(@Param("username")String username);
}
