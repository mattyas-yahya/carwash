package com.example.repo;

import com.example.model.PreventiveMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface repo_pm  extends JpaRepository<PreventiveMaintenance,String>
{
  String Q3="delete from preventive_maintenance  where id_pm in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdata(List<String> id_pm);

  String Q4="insert into jadwal (id_jadwal,id_pm,start,kode_pm,title,status) values(?1,?2,?3,?4,?5,?6);  ";
  @Modifying
  @Transactional
  @Query(value =Q4 ,nativeQuery = true)
  int insertdata(String id_jadwal,String id_pm, String start, String kode_pm, String title,String Status);
}
