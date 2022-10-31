package com.divups.ead.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "special_hires")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SpecialBusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer special_hiring_id;
    private Integer no_of_seats;
    private Double payment_rate;
    private String facillities;
    private Integer contact_no;
    private String facebook_link;
    private String insta_link;
    private String bus_name;
    private String specialbus_type;
    private Instant specialbus_added;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="busowner_id",referencedColumnName ="bus_owner_id")
    private BusOwnerEntity busOwner;
}
