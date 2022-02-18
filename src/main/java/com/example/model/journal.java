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
public class journal
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
String id_journal;
    @DateTimeFormat(pattern = "yyyy-MM-dd")  @Column(name="journal_date", nullable=false)  @Temporal(TemporalType.DATE)  private Date journal_date;
    @Column(name = "journal_code", unique = true, nullable = false)
    String journal_code;
    String Line;

}
