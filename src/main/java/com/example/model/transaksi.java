package com.example.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "transaksi")
public class transaksi 
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_transaksi", unique = true, nullable = false)
    String id_transaksi;
String kode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name="transaction_date", nullable=false)
        @Temporal(TemporalType.DATE)
        private Date transaction_date;

        String nama_pelanggan;

        String jenis_kendaraan;

        String merek;

String nopol;   

int biaya;    
}
