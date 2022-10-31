package com.divups.ead.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.sql.Date;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name="buses")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bus_id;
    @NotEmpty
    private String start_point;
    @NotEmpty
    private String end_point;
    private String bus_type;
    private Boolean status;
    private Integer no_of_seats;
    private Double rate;
    private Date added_on;
//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name="bus_owner_id",referencedColumnName ="bus_owner_id")
//    private BusOwnerEntity busOwner;
}
