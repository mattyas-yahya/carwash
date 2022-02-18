package com.example.repo;

import com.example.model.Tr_asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface repo_tr_asset extends JpaRepository<Tr_asset,String>
{
  String Q12="select any_value((select count(id_tr_asset) from tr_asset))as total_active_asset,any_value((select count(id_tr_asset)as active from tr_asset where status like 'active')) as active, any_value((select count(id_tr_asset)as repair from tr_asset where status like 'repair')) as repair,any_value((select count(id_tr_asset)as disposal from tr_asset where status like 'disposal')) as disposal ";
  @Query(value = Q12,nativeQuery = true)
  List asset_info();

  String Q3="delete from Tr_asset  where id_tr_asset in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdataAll(List<String> id_asset);

  String Q4="select count(id_tr_asset)  from Tr_asset ";
  @Query(value = Q4,nativeQuery = true)
  List sum_asset();

  String Q5="select count(id_tr_asset) as status_ from Tr_asset where status like 'Active' ";
  @Query(value = Q5,nativeQuery = true)
  List CountActive();

  String Q6="select count(id_tr_asset) as status_ from Tr_asset where status like 'Disposal' ";
  @Query(value = Q6,nativeQuery = true)
  List CountDisposal();

  String Qy="SELECT * FROM Tr_asset where status like 'Active' ";
  @Query(value = Qy,nativeQuery = true)
  List<Tr_asset> findActive();

  String Q8="SELECT count(id_tr_asset) as status_ FROM Tr_asset where status like 'Repair' ";
  @Query(value = Q8,nativeQuery = true)
  List CountRepair();

  String Q7="update Tr_asset set status='repair' where asset_code=?1 ";
  @Modifying
  @Transactional
  @Query(value =Q7 ,nativeQuery = true)
  int SetRepair(String kode_asset);

  String Q10="SELECT * FROM Tr_asset where status != 'repair' ";
  @Query(value = Q10,nativeQuery = true)
  List<Tr_asset> NotRepair();

  String Q9="  update Tr_asset set status='Active' where asset_code=(select kode_asset from work_orders where kode_wo=?1 )";
  @Modifying
  @Transactional
  @Query(value =Q9 ,nativeQuery = true)
  int SetActive(String wo_code);



}
