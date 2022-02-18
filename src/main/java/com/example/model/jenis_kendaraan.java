package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class jenis_kendaraan 
{
    @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_jenis_kendaraan", unique = true, nullable = false)
String id_jenis_kendaraan;
String jenis_kendaraan;
String merek;
String biaya;    
}
