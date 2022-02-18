package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@DynamicUpdate
public class journal_transaction
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
String id_journal_transaction;
    @DateTimeFormat(pattern = "yyyy-MM-dd")  @Column(name="journal_date", nullable=false)  @Temporal(TemporalType.DATE)  private Date journal_date;
    @Column(name = "journal_code",  nullable = false)
    String journal_code;
    String idstok_card;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="date_transaction", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date date_transaction;
    String kode_inventory;
    int harga;
    int stok_awal;
    int transfer;
    int consume;
    int adjustment;
    int stok_akhir;
    String note;

}
