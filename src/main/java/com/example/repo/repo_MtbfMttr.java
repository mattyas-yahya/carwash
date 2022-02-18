package com.example.repo;

import com.example.model.MtbfMttr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_MtbfMttr extends JpaRepository<MtbfMttr,String>
{


  String Q="select tgl_,sum(down_time)as down_time FROM cmms.mtbf_mttr group by tgl_  ";
  @Modifying
  @Query(value = Q,nativeQuery = true)
  List SumDT();

}
