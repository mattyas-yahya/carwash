package com.example.repo;

import com.example.model.plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_plant extends JpaRepository<plant,String> {

    String Q3="delete from plant  where id_plant in ?1";
    @Modifying
    @Query(value =Q3 ,nativeQuery = true)
    int hapusdataAll(List<String> id_plant);
}
