package com.example.repo;

import com.example.model.dashboard;
import com.example.model.work_orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface repo_wo extends JpaRepository<work_orders,String>
{
  dashboard d= new dashboard();
@Autowired
  repo_dashboard rr = null;

    String Q8="select any_value((select count(id_wo) from work_orders))as id_wo,any_value((select count(id_wo)as end_job from work_orders where status_pekerjaan like 'end_job')) as end_job, any_value((select count(id_wo)as end_job from work_orders where status_pekerjaan like 'work_in_progress')) as work_in_progress,any_value((select count(id_wo)as end_job from work_orders where status_pekerjaan like 'take_over')) as take_over";
    @Query(value = Q8,nativeQuery = true)
    List work_orders_info();

String Q7="select id_wo,id_dept,id_tr_asset,quantity,uom,batch_no,breakdown,cycle_time,cycle_time,good_pieces,jenis_pekerjaan,kode_asset,kode_wo,lokasi,mtbf,mttr,nama_dept,pembuatan,prioritas,product_name,setup,solution,status_pekerjaan,title,work_time,uptime,downtime,breakdown,IFNULL(work_time-(breakdown+setup),0) as AR ,IFNULL(((Quantity/work_time*cycle_time)*100),0) AS PR,IFNULL(((good_pieces / Quantity )* 100),0) AS QR, IFNULL(uptime+downtime/breakdown,0) AS mtbf,IFNULL(downtime/breakdown,0) AS mttr FROM work_orders where status_pekerjaan <> 'End_Job' and status_pekerjaan <> 'Costing' ";
    @Query(value = Q7,nativeQuery = true)
    List<work_orders> FindAllv1();

    String xx ="SELECT * FROM work_orders where status_pekerjaan <> 'End_Job' and status_pekerjaan <> 'Costing'";
    @Query(value = xx,nativeQuery = true)
    List<work_orders> findByVerified();

//    String xxx ="<> verified";
//    @Query(value = "select * from work_order  where status_pekerjaan ='"+xxx+"'",nativeQuery = true)
//    List<work_order> findQ();

    String Q1x="SELECT * FROM work_orders where status_pekerjaan <> 'End_Job' and status_pekerjaan <> 'Verified' and status_pekerjaan <> 'approved'";
    @Query(value = Q1x,nativeQuery = true)
    List<work_orders> findby_TAKEOVER_WIP();

    String Q="select * FROM work_orders where status_pekerjaan <>'Verified' and status_pekerjaan <> 'End_Job' and status_pekerjaan <> 'take_over' ";
    @Query(value = Q,nativeQuery = true)
    List<work_orders> findQ();

    String Qx="select * FROM work_orders where status_pekerjaan <> 'Verified' and status_pekerjaan <> 'Approved' and status_pekerjaan <> 'Work_In_Progrees'";
    @Query(value = Qx,nativeQuery = true)
    List<work_orders> findX();

    String Qy="SELECT * FROM work_orders where status_pekerjaan = 'take_over' ";
    @Query(value = Qy,nativeQuery = true)
    List<work_orders> findTake();

    String Q2="SELECT * FROM work_orders where kode_asset = ?1";
    @Query(value =Q2 ,nativeQuery = true)
    List<work_orders> findbykode(String kode_spare_part );

    String Qrtl="select  pembuatan, sum(downtime) from work_orders  group by  YEAR(pembuatan)  HAVING pembuatan  order by pembuatan asc ";
    @Modifying
    @Query(value =Qrtl ,nativeQuery = true)
    List findQrtl();

   String Q3="select count(status_pekerjaan) as status_ from work_orders ";
  @Query(value = Q3,nativeQuery = true)
    List sum_status();

    String Q4="select count(status_pekerjaan) as status_ from work_orders where status_pekerjaan like 'End_Job' ";
    @Query(value = Q4,nativeQuery = true)
    List sum_End_Job();

    String Q5="select count(status_pekerjaan) as status_ from work_orders where status_pekerjaan like 'take_over' ";
    @Query(value = Q5,nativeQuery = true)
    List sum_take_over();

    String Q6="select count(status_pekerjaan) as status_ from work_orders where status_pekerjaan like 'Work_In_Progrees' ";
    @Query(value = Q6,nativeQuery = true)
    List sum_Work_In_Progrees();


  String Q123="select id_wo,kode_wo,title from work_orders where status_pekerjaan like 'End_Job' ";
  @Query(value = Q123,nativeQuery = true)
  List SelectEndJob();


  String D="delete from work_orders  where id_wo in ?1";
  @Modifying
  @Query(value =D ,nativeQuery = true)
  int hapusdataAll(List<String> id_wo);

  String Q0="select pembuatan as tgl,sum(downtime) as downtime from work_orders GROUP BY pembuatan  ";
  @Query(value = Q0,nativeQuery = true)
  List sumDT();

  String Q01="select pembuatan,sum(downtime) as downtime_ from work_orders where pembuatan between ?1 and ?2 group by pembuatan";
  @Modifying
  @Query(value = Q01,nativeQuery = true)
  List sumDT1(String t1,String t2 );


   String D112="update work_orders set status_pekerjaan = 'Costing' where kode_wo like ?1 ";
  @Modifying
  @Transactional
  @Query(value =D112 ,nativeQuery = true)
  int  Costingin(String kode_wo );

  String D113="update jadwal set status = 'Costing' where kode_pm like ?1 ";
  @Modifying
  @Transactional
  @Query(value =D113 ,nativeQuery = true)
  int  Costinginpm(String kode_pm );


//UPDATE `cmms`.`work_order` SET `status_pekerjaan`='Verified', `uptime`='123', `selesai`='2020-02-22', `solution`='ccccccc' WHERE `id_wo`='ac9debf7-4cc0-474b-b3c1-8d435e0adad2';
 String D114="UPDATE work_orders SET status_pekerjaan=?1, uptime=?2, selesai=?3, solution=?4 WHERE id_wo=?5 ";
  @Modifying
  @Transactional
  @Query(value =D114 ,nativeQuery = true)
  int UpdateWo(String status_pekerjaan,double uptime,String selesai,String solution,String id_wo  );

  String Q31="delete from work_orders  where id_wo in ?1";
  @Modifying
  @Query(value =Q31 ,nativeQuery = true)
  int hapusdata(List<String> id_wo);


 String Q32= "select id_wo,id_asset,id_dept,id_pm,quantity,uom,batch_no,cycle_time,downtime,good_pieces,jenis_pekerjaan,kode_asset,kode_wo,lokasi,nama_dept,pembuatan,prioritas,\n"+
    "    product_name,quantity_troble,solution,status_pekerjaan,title,uptime,work_time,\n"+
    "((work_time-downtime/work_time) *100) as AR ,\n"+
    "((quantity/work_time * cycle_time ) * 100) as PR ,\n"+
    "(good_pieces / quantity) * 100 as QR ,\n"+
    "(uptime/quantity_troble) as MTBF,\n"+
    "(downtime/quantity_troble) as MTTR\n"+
    "  from work_orders;";
  @Query(value =Q32 ,nativeQuery = true)
  List<work_orders> NewfindAll();


  String Q33="select id_wo,id_asset,id_dept,id_pm,quantity,uom,batch_no,cycle_time,downtime,good_pieces,jenis_pekerjaan,kode_asset,kode_wo,lokasi,nama_dept,pembuatan,prioritas,\n" +
    "product_name,quantity_troble,solution,status_pekerjaan,title,uptime,work_time,\n" +
    "((work_time-downtime/work_time) *100) as AR ,\n" +
    "((quantity/work_time * cycle_time ) * 100) as PR ,\n" +
    "(good_pieces / quantity) * 100 as QR ,\n" +
    "(uptime/quantity_troble) as MTBF,\n" +
    "(downtime/quantity_troble) as MTTR\n" +
    " from work_orders\n" +
    " where status_pekerjaan <>'Verified' and status_pekerjaan <> 'End_Job' and status_pekerjaan <> 'take_over' and status_pekerjaan <> 'Costingin'; ";
  @Query(value = Q33,nativeQuery = true)
  List<work_orders> NewfindQ();


  String Q1234="SELECT KODE_ASSET,STATUS_PEKERJAAN,JENIS_PEKERJAAN,COUNT(TITLE)AS SUM_PROBLEM FROM WORK_ORDERS GROUP BY KODE_ASSET , STATUS_PEKERJAAN,JENIS_PEKERJAAN";
  @Query(value = Q1234,nativeQuery = true)
  List Wo_Overview();


}
