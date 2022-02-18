package com.example.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Data
@Entity
public class Formula
{
  @Id
  @GeneratedValue(generator = "uuid")  @GenericGenerator(name = "uuid", strategy = "uuid2")  @Column(name = "id_formula", unique = true, nullable = false)  String id_formula;
  @JoinColumn(name = "id_inventory")  @ManyToOne  private inventaris id_inventory;
String kode_formula;
String version;
  String formula_name;
String kode_Items;
int qty;
  int price;
  int amount;
String UOM;
}
