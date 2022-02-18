package com.example.repo;

import com.example.model.purc_req;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_purc_req extends JpaRepository<purc_req,String>
{
  String Q3="delete from purc_req  where id_pr_req in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdataAll(List<String> id_purc_req);
}
