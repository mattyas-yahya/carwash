package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@NoArgsConstructor
@Entity
public class sparepart
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_sparepart", unique = true, nullable = false)
    String id_sparepart;
    @Column(name = "asset_name")
    String asset_name;
    @Column(name = "asset_code")
    String asset_code;
    @Column(name = "serial")
    String serial;
    @Column(name = "kode_spare_part")

    String kode_spare_part;
    @Column(name = "nama_spare_part")

    String nama_spare_part;
    @Column(name = "quantity")

    int quantity;
}
