package com.example.repo;

import com.example.model.transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
public interface repo_transaksi extends JpaRepository<transaksi,String>{

    String Q10="SELECT any_value(id_transaksi) as id_transaksi,sum(biaya)as biaya ,any_value(transaction_date) as transaction_date, any_value(jenis_kendaraan) as jenis_kendaraan,any_value(kode) as kode FROM transaksi  GROUP BY transaction_date ";
    @Query(value = Q10,nativeQuery = true)
    List<transaksi> sum_biaya();

    String Q5="select transaction_date ,sum(biaya) as pemasukan from transaksi where transaction_date between ? and ? group by transaction_date  order by transaction_date ";
    @Query(value =Q5 ,nativeQuery = true)
    List stok_barang2(Date start_date,Date end_date);
}
