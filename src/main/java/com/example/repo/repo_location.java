package com.example.repo;

import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_location extends JpaRepository<Location,String> {
    String Q3="delete from location  where id_location in ?1";
    @Modifying
    @Query(value =Q3 ,nativeQuery = true)
    int hapusdata(List<String> id_location);

}
