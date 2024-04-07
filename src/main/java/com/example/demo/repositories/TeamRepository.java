package com.example.demo.repositories;

import com.example.demo.models.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    @Query(value = """
            select * from teams t
            where UPPER(t.nombre) like UPPER(CONCAT('%', :nombre, '%'))
            """, nativeQuery = true)
    List<Team> getTeamsByName(@Param("nombre") String nombre);
}
