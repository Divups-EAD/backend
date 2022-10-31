package com.divups.ead.Model;

import com.divups.ead.Entity.BusOwnerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SpecialBus {
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
    private BusOwnerEntity busOwner;
}
