package com.divups.ead.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SpecialBus {
    private Integer special_hiring_id;
    private Integer no_of_seats;
//    private Double payment_rate;
    private String facillities;
    private String contact_no;
    private String facebook_link;
    private String insta_link;
    private String bus_name;
    private String specialbus_type;
   // private Date specialbus_added;
//    private BusOwnerEntity busOwner;
}
