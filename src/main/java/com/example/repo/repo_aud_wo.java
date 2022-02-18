package com.example.repo;

import com.example.model.work_orders_aud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_aud_wo  extends JpaRepository<work_orders_aud,String>
{
    String Q32= "select id_wo_aud,id_dept,id_tr_asset,quantity,uom,batch_no,breakdown,cycle_time,cycle_time,good_pieces,jenis_pekerjaan,kode_asset,kode_wo,lokasi,mtbf,mttr,nama_dept,pembuatan,prioritas,product_name,setup,solution,status_pekerjaan,title,work_time,uptime,downtime,breakdown\n" +
            ",IFNULL(work_time-(breakdown+setup),0) as AR ,\n" +
            "IFNULL(((Quantity/work_time*cycle_time)*100),0) AS PR,\n" +
            "IFNULL(((good_pieces / Quantity )* 100),0) AS QR,\n" +
            "IFNULL(uptime+downtime/breakdown,0) AS mtbf,\n" +
            "IFNULL(downtime/breakdown,0) AS mttr\n" +
            "FROM work_orders_aud";
    @Query(value =Q32 ,nativeQuery = true)
    List<work_orders_aud> NewfindAll();
}
