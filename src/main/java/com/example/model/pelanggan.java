package com.example.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@Entity


public class pelanggan 
{
    @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id_pelanggan", unique = true, nullable = false)
String id_pelanggan;
@Column(name = "kode_pelanggan",  nullable = false)
String kode_pelanggan; //nik or no unik lainya
String nama_pelanggan;
String jenis_kendaraan;
String merek;
@Column(name = "nopol", unique = true, nullable = false)
String nopol;   
String biaya;    
}
