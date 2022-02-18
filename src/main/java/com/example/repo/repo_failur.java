package com.example.repo;

import com.example.model.failur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_failur extends JpaRepository<failur,String>
{

  String Q="select *,(severity*occurance*detection)as rpn FROM cmms.failur  ";
    @Query(value = Q,nativeQuery = true)
    List<failur> findRPN();

}
