package com.example.repo;

import com.example.model.cost_doc_dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_cost_doc_dashboard extends JpaRepository<cost_doc_dashboard,String>
{


//  public String x=repo_dashboard.Q12;
String Q9="select any_value(year(id_cost_doc)) as id_cost_doc_dashboard, any_value(year(pembuatan)) as year, any_value(MONTHNAME(pembuatan)) as month,any_value(sum(total)) as total from cost_doc GROUP BY YEAR(pembuatan), MONTH(pembuatan)";
  @Query(value = Q9,nativeQuery = true)
 // List SumCostByMonth();
  List<cost_doc_dashboard> SumCostByMonth();


}
