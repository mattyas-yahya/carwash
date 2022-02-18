package com.example.repo;

import com.example.model.Onhand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_onhand extends JpaRepository<Onhand,String>
{
    String Q4=" SELECT any_value(IDSTOK_CARD),any_value(id_onhand),any_value(kode_inventory) ,sum(stok_awal),sum(transfer),sum(consume),sum(adjustment),((sum(stok_awal)+sum(transfer))-(sum(consume)+sum(adjustment)))as stok_akhir FROM cmmsq.stok_card  group by any_value(kode_inventory) order by any_value(kode_inventory);";
    @Query(value =Q4 ,nativeQuery = true)
  String stok_barang();

    String Q5="SELECT any_value(IDSTOK_CARD),any_value(kode_inventory) ,sum(stok_awal),sum(transfer),sum(consume),sum(adjustment),((sum(stok_awal)+sum(transfer))-(sum(consume)+sum(adjustment)))as stok_akhir FROM cmmsq.stok_card where date_transaction between ?1 and  ?2 group by any_value(kode_inventory) order by any_value(kode_inventory);";
    @Query(value =Q5 ,nativeQuery = true)
    List<Onhand> stok_barang2(String start_date,String end_date);
}
