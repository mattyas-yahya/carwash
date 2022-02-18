package com.example.repo;

import com.example.model.stok_card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface repo_stok_card extends JpaRepository<stok_card,String>
{
    String Q4=" SELECT any_value(id_onhand),any_value(kode_inventory) ,sum(stok_awal),sum(transfer),sum(consume),sum(adjustment),((sum(stok_awal)+sum(transfer))-(sum(consume)+sum(adjustment)))as stok_akhir FROM cmmsq.stok_card  group by any_value(kode_inventory) order by any_value(kode_inventory);";
    @Query(value =Q4 ,nativeQuery = true)
  List stok_barang();

    //    String Q5="SELECT any_value(id_onhand),any_value(kode_inventory) ,sum(stok_awal),sum(transfer),sum(consume),sum(adjustment),((sum(stok_awal)+sum(transfer))-(sum(consume)+sum(adjustment)))as stok_akhir FROM cmmsq.stok_card where date_transaction between ? and  ? group by any_value(kode_inventory) order by any_value(kode_inventory);";
    String Q5="SELECT any_value(idstok_card)as idstok_card,any_value(kode_inventory)as kode_inventory ,any_value(harga)as harga, any_value(date_transaction) as date_transaction ,sum(stok_awal) as stok_awal ,sum(transfer) as transfer,sum(consume) as consume ,sum(adjustment) as adjustment ,((sum(stok_awal)+sum(transfer))-(sum(consume)+sum(adjustment)))as stok_akhir ,any_value(note) as note FROM cmmsq.stok_card where date_transaction between ? and  ? group by any_value(kode_inventory) order by any_value(kode_inventory);";
    @Query(value =Q5 ,nativeQuery = true)
    List<stok_card> stok_barang2(String start_date,String end_date);

    //    String Q5="SELECT any_value(id_onhand),any_value(kode_inventory) ,sum(stok_awal),sum(transfer),sum(consume),sum(adjustment),((sum(stok_awal)+sum(transfer))-(sum(consume)+sum(adjustment)))as stok_akhir FROM cmmsq.stok_card where date_transaction between ? and  ? group by any_value(kode_inventory) order by any_value(kode_inventory);";
    String Q6=" SELECT any_value(idstok_card) as idstok_card, any_value(note) as note,any_value(date_transaction) as date_transaction,any_value(harga)as harga,any_value(kode_inventory)as kode_inventory, any_value(SUM(stok_awal)) as stok_awal ,any_value(SUM(consume)) as consume ,any_value (sum(transfer)) as transfer,any_value (sum(adjustment)) as adjustment,any_value((stok_awal+transfer)-consume) as stok_akhir FROM stok_card WHERE date_transaction BETWEEN ? AND ? and kode_inventory like ? group by date_transaction ;";
    @Query(value =Q6 ,nativeQuery = true)
    List<stok_card> stok_card(String start_date,String end_date,String kode_inventory);

String Q7="insert into stok_card (idstok_card,date_transaction,kode_inventory,harga,consume) values(?,?,?,?,?)";
  @Modifying
  @Transactional
@Query(value = Q7,nativeQuery = true)
  int SAVE_COST_DOC_TO_STOCK_CARD(String idstok_card, String date_transaction,String kode_inventory, int harga, int consume);
}
