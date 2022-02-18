package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@Entity
public class suku_cadang
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id_suku_cadang;
    @Size(min=0)
    private String ast_name;
    @Size(min=0)
    private String srl;
    @Column(name = "asset_code")
    private String ast_code;
    @Column private String kode_suku_cadang; //kode item
    private String nama_suku_cadang;
    BigInteger jumlah;
}
