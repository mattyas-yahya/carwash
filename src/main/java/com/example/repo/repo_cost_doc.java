package com.example.repo;

import com.example.model.cost_doc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface repo_cost_doc extends JpaRepository<cost_doc,String>
{


//  public String x=repo_dashboard.Q12;
//String Q9="select any_value(year(pembuatan)) as year, any_value(MONTHNAME(pembuatan)) as month,any_value(sum(total)) as total from cost_doc GROUP BY YEAR(pembuatan), MONTH(pembuatan)";
 String Q9="select any_value(MONTHNAME(pembuatan)) as month,any_value(sum(total)) as total from cost_doc GROUP BY YEAR(pembuatan), MONTH(pembuatan)";

 @Query(value = Q9,nativeQuery = true)
 List SumCostByMonth();
 // List<cost_doc_dashboard> SumCostByMonth();

  String Q3="delete from cost_doc  where id_cost_doc in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdataAll(List<String> id_cost_doc);

  String Q8="SELECT DATE_FORMAT(pembuatan, \"%m-%Y\") AS Month_Year ,SUM(total) FROM cost_doc GROUP BY DATE_FORMAT(pembuatan, \"%m-%Y\") ,id_cost_doc";
  @Query(value = Q8,nativeQuery = true)
  List sumCost();

  String Q1="  SELECT b.id_account,b.kode,b.keterangan,sum(a.total) as total_biaya \n" +
    "FROM cmmsq.cost_doc a , account b\n" +
    "group by b.kode ";
  @Query(value = Q1,nativeQuery = true)
  List CountAccount();

  String Q2="select a.account as account_kode,sum(a.total) as total_biaya from cost_doc a  group by account  ";
  @Query(value = Q2,nativeQuery = true)
  List sumCostbyAccount();


  String Q4="select kode_wo,title ,status_pekerjaan from work_orders where status_pekerjaan = 'End_Job' union select kode_pm ,title ,status from jadwal where status = 'End_Job' order by kode_wo";
  @Query(value = Q4,nativeQuery = true)
  List issue();

  String Q5="select kode_wo,title ,status_pekerjaan from work_orders where status_pekerjaan = 'Costing' union select kode_pm ,title ,status from jadwal where status = 'Costing' order by kode_wo";
  @Query(value = Q5,nativeQuery = true)
  List issue_costing();

  String Q6="update Onhand set pemakaian=pemakaian+? where id_onhand =?";
  @Modifying
  @Transactional
  @Query(value =Q6 ,nativeQuery = true)
  int pemakaian(int pemakaian,String id_onhand);

  String Q7="select  pembuatan as c_date,sum(a.total) as total_biaya from cost_doc a  group by pembuatan  ";
  @Query(value = Q7,nativeQuery = true)
  List sumCostbyDate();
}
