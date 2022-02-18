package com.example.repo;

import com.example.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface repo_asset extends JpaRepository<Asset,String>
{

  String Q3="delete from asset  where id_asset in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdataAll(List<String> id_asset);

  String Q4="select count(id_asset)  from asset ";
  @Query(value = Q4,nativeQuery = true)
  List sum_asset();



  String Qy="SELECT * FROM asset where status like 'Active' ";
  @Query(value = Qy,nativeQuery = true)
  List<Asset> findActive();



  String Q8="SELECT * FROM asset where status != 'repair' ";
  @Query(value = Q8,nativeQuery = true)
  List<Asset> NotRepair();

  String Q9="  update asset set status='Active' where asset_code=(select kode_asset from work_orders where kode_wo=?1 )";
  @Modifying
  @Transactional
  @Query(value =Q9 ,nativeQuery = true)
  int SetActive(String wo_code);

}
