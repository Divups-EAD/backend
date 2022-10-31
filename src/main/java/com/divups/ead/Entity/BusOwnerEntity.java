package com.divups.ead.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "bus_owner")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BusOwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bus_owner_id;
    private String license_no;
    private String travelsname;
    private Integer contact_no;
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "owner_details",referencedColumnName = "user_id")
    private UserEntity user;
}
