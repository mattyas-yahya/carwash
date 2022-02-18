package com.example.repo;

import com.example.model.Departemen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_departemen extends JpaRepository<Departemen,String>
{
  //delete from User u where u.id in ?1
  String Q3="delete from departemen  where id_dept in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdata(List<String> id_spare_part);
}
