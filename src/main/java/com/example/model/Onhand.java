package com.example.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
public class Onhand {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_onhand", unique = true, nullable = false)
    String id_onhand;
    @Column  String id_items;
    @Size(min=0)
    @Column(name = "kode_inventory", unique = true, nullable = false)
    String kode_inventory;
    @Size(min=0)
    @Column  String nama;
    @Size(min=0)
    @Column  String jenis;
    @Column   int stok_awal;
    @Column  int transfer;
    @Column  int pemakaian;
    @Column  int adjustment;
    @Column  int stok_akhir;
    @Column  String uom;
    @Column  int harga;

}
