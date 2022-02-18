package com.example.repo;

import com.example.model.project_material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface repo_project_material extends JpaRepository<project_material,String>
{
  String Q3="delete from project_material  where id_project_material in ?1";
  @Modifying
  @Query(value =Q3 ,nativeQuery = true)
  int hapusdataAll(List<String> id_project_material);

  String Q1="update Inventory set penjualan=penjualan+? where id_inventory =?";
  @Modifying
  @Transactional
  @Query(value =Q1 ,nativeQuery = true)
  int pembelian(int penjualan, String id_inventory);
}
