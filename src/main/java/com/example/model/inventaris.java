package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@Entity

public class inventaris
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_inventaris", unique = true, nullable = false)
String id_inventaris;
String id_items;
    @Size(min=0, max=30)
    String kd_inventaris;
    @Size(min=0, max=30)
    String nma;
    @Size(min=0, max=30)
    String jns;
    int stok_awal;
    int transfer;
    int pemakaian;
    int adjustment;
    int stok_akhir;
    String uom;
    int hrga;






}
