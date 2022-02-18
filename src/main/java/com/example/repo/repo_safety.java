package com.example.repo;

import com.example.model.Safety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_safety extends JpaRepository<Safety,String> {

  String Q3="delete from Safety where id_safety in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdataAll(List<String> id_safety);
}
