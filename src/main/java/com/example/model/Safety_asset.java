package com.example.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Safety_asset
{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_safety_asset", unique = true, nullable = false)
  String id_safety_asset;

  @Column(name = "asset_code",  nullable = false)
  private String asset_code;

  String referensi;
  String keterangan;
  String safety_procedure;
  String alat_safety;
}
