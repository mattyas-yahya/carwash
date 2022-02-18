package com.example.repo;

import com.example.model.jadwal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface repo_jadwal extends JpaRepository<jadwal,String>
{
  String Q7="select any_value((select count(id_wo)as total_pm from work_orders where kode_wo like '%PM%')) as total_pm,any_value((select count(id_wo)as work_in_progress from work_orders where status_pekerjaan like 'work_in_progress' and kode_wo like '%PM%')) as work_in_progress,any_value((select count(id_wo)as end_job from work_orders where status_pekerjaan like 'End_Job' and kode_wo like '%PM%')) as End_Job,any_value((select count(id_wo)as take_over from work_orders where status_pekerjaan like 'take_over' and kode_wo like '%PM%')) as take_over";
  @Query(value = Q7,nativeQuery = true)
  List jadwal_info();

  String Q="SELECT start,end,concat(title,status)as title FROM jadwal";
  @Modifying
  @Query(value =Q ,nativeQuery = true)
  List jadwal_pm();

  String Q3="delete from jadwal  where id_jadwal in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdataAll(List<String> id_jadwal);


  String Q1="select count(id_jadwal) as id_jadwal from jadwal  ";
  @Modifying
  @Query(value = Q1,nativeQuery = true)
  List sum_all_pm();

  String Q4="select count(id_jadwal) as status_ from jadwal where status like 'End_Job' ";
  @Modifying
  @Query(value = Q4,nativeQuery = true)
  List sum_End_Job();

  String Q5="select count(id_jadwal) as status_ from jadwal where status like 'take_over' ";
  @Modifying

  @Query(value = Q5,nativeQuery = true)
  List sum_take_over();

  String Q6="select count(id_jadwal) as status_ from jadwal where status like 'Work_In_Progrees' ";
  @Modifying
  @Query(value = Q6,nativeQuery = true)
  List sum_Work_In_Progrees();

  String D112="update jadwal set status = 'Costing' where id_jadwal like ?1 ";
  @Modifying
  @Transactional
  @Query(value =D112 ,nativeQuery = true)
  int  Costingin(String id_jadwal );

  String D113="insert into jadwal(kode_pm,start,end,title,lokasi)values(?1,?2,?3,?4,?5) ";
  @Modifying
  @Transactional
  @Query(value =D113 ,nativeQuery = true)
  int save_manual(String kode_pm, Date start, Date end, String title,String lokasi);
}
