package com.example.repo;

import com.example.model.header_pr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_header_pr extends JpaRepository<header_pr,String>
{
  String Q3="delete from header_pr  where id_header_pr in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdataAll(List<String> id_purc_req);


  String Q1 ="SELECT * FROM header_pr where status like 'validate'";
  @Query(value = Q1,nativeQuery = true)
  List<header_pr> findByValidate();

  String Q2 ="SELECT * FROM header_pr where status like 'post'";
  @Query(value = Q2,nativeQuery = true)
  List<header_pr> findByPost();

}
