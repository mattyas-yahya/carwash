package com.example.repo;

import com.example.model.pekerja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_pekerja extends JpaRepository<pekerja,String> {
  String Q3="delete from pekerja  where id_pekerja in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdataAll(List<String> id_pekerja);
}
