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

public class Journal_transfer
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id_journal_transfer;

    @JoinColumn(name = "id_onhand")
    @ManyToOne
    Onhand id_onhand;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  @Column(name="consume_date", nullable=false)  @Temporal(TemporalType.DATE)  private Date consume_date;
    String kode_inventory;

    int amount;
}
