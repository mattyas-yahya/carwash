package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Audited

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "Tr_asset")
public class Tr_asset
{

        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid2")
        @Column(name = "id_tr_asset", unique = true, nullable = false)
        String id_tr_asset;

        @JoinColumn(name = "id_asset")
        @ManyToOne
        private Asset  id_asset;

        @Column(name = "asset_name",  nullable = false)

        private String asset_name;

        @Column(name = "serial",  nullable = false)
        private String serial;

        @Column(name = "asset_code", unique = true, nullable = false)
        private String asset_code;

        private String parent_code;


        private String location;

        private String asset_tag;

        String safety_referensi;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name="installation_date", nullable=false)
        @Temporal(TemporalType.DATE)
        private Date installation_date;

        String status;

        String reason;

        String aseet_usage;
    }














