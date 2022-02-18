package com.example.repo;

import com.example.model.Bom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface repo_Bom extends JpaRepository<Bom, UUID>
{
//  insert into cmmsq.bom(uom,create_date,formula_name,kode_items,kode_bom,kode_formula,note,consume,proposal,total)
//  select b.uom,a.create_date,b.formula_name,b.kode_Items,a.kode_bom,b.kode_formula,a.note,a.Quantity,b.price,(a.Quantity*b.price)as total
//  from formula b,
//  header_bom a
//  where a.kode_bom=?
//  and b.kode_formula=?
//  and a.Quantity=?
String Q2="  insert into cmmsq.bom(uom,create_date,formula_name,kode_items,kode_bom,kode_formula,note,consume,proposal,total)\n" +
        "  select b.uom,a.create_date,b.formula_name,b.kode_Items,a.kode_bom,b.kode_formula,a.note,a.Quantity,b.amount,(a.Quantity*b.amount)as total\n" +
        "  from formula b,\n" +
        "  header_bom a\n" +
        "  where a.kode_bom=?\n" +
        "  and b.kode_formula=?\n" +
        "  and a.Quantity=? ";
  //String Q2="insert into bom (id_bom,id_header_bom,id_formula,kode_bom,kode_formula,formula_name,kode_Items,proposal,uom) select a.id_header_bom as id_bom ,b.kode_Items,b.proposal,b.uom from header_bom a,formula b LEFT JOIN bom c  ON c.id_header_bom = c.id_formula where a.kode_bom=? and b.kode_formula=?";
  @Modifying
  @Transactional
  @Query(value =Q2 ,nativeQuery = true)
  int bom_pl(String kode_bom, String kode_formula,int Quantity);

  String Q5=" select b.uom,a.create_date,b.formula_name,b.kode_Items,a.kode_bom,b.kode_formula,a.note,a.Quantity,b.amount,(a.Quantity*b.amount)as total\n" +
          " from formula b, \n" +
          " header_bom a \n" +
          ";";
  @Query(value = Q5,nativeQuery = true)
  List SelectAllByTotal();
}
//// update Inventory set penjualan = (select a.consume*a.proposal as penjualan from bom a where a.formula_name like 'mobil'  ORDER BY a.formula_name)
//where kode_inventory = (select b.kode_items as kode_inventory from bom b where b.formula_name like 'mobil'  ORDER BY b.formula_name);///
