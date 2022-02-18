package com.example.repo;

import com.example.model.sparepart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo_spare extends JpaRepository<sparepart,String>
{

//   String Q="SELECT a.id_spare_part,c.id_safety,a.lokasi, b.kode_asset, a.kode_spare_part, a.nama_spare_part,c.referensi, a.tgl_beli_spare, a.vendor,b.id_asset, b.garansi, a.harga_beli, a.serial, a.stok, a.consume, (a.stok-a.consume) as end_balance FROM spare_part a , asset b , safety c where a.id_asset=b.id_asset and c.id_safety=a.id_safety  group by c.id_safety, b.id_asset,a.id_spare_part";
//    @Query(value =Q ,nativeQuery = true)
//    List<Sparepart> spare_Data();
//
//    String Q4="SELECT a.id_spare_part,a.lokasi, b.kode_asset, a.kode_spare_part, a.nama_spare_part, a.tgl_beli_spare, a.vendor,b.id_asset, b.garansi, a.harga_beli, a.serial, a.stok, a.consume, (a.stok-a.consume) as end_balance  FROM spare_part a join asset b where a.id_asset=b.id_asset group by a.id_spare_part";
//    @Query(value =Q4 ,nativeQuery = true)
//    List<Sparepart> spare_Data_is_zero();
//
//    String Q1="SELECT * FROM spare_part where kode_spare_part = ?1";
//    String Q2="SELECT * FROM work_order where kode_asset = ?1";
//    @Query(value =Q1 ,nativeQuery = true)
//    List<Sparepart> findbykode(String kode_spare_part );
//
//    String Q3="update spare_part set consume =? where id_spare_part =?";
//    @Modifying
//    @Transactional
//    @Query(value =Q3 ,nativeQuery = true)
//    int pemakaian(int consume,String id_spare_part);
}
