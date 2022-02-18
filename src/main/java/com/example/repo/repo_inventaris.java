package com.example.repo;

import com.example.model.inventaris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_inventaris extends JpaRepository<inventaris,String>
{
  String D="delete from Inventory  where id_inventory in ?1";
  @Modifying
  @Query(value =D ,nativeQuery = true)
  int hapusdataAll(List<String> id_inventory);

  String Q4="SELECT id_inventory,id_items,kode_inventory,nama,jenis,harga,stok_awal,pemakaian,transfer,adjustment,(stok_awal+transfer+adjustment-pemakaian)as stok_akhir,uom FROM Inventory;";
  // String Q4="SELECT id_barang,nama,jenis,harga_beli,harga_jual,stok_awal,transfer,penjualan,(stok_awal+transfer-penjualan)as stok_akhir FROM pos.barang";
  @Query(value =Q4 ,nativeQuery = true)
  List<inventaris> stok_barang();
}
