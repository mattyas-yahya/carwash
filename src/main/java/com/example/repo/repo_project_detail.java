package com.example.repo;

import com.example.model.project_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_project_detail extends JpaRepository<project_detail,String>
{
  String Q3="delete from project_detail  where id_project_detail in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdataAll(List<String> id_project_detail);
}