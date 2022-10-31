package com.divups.ead.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BusOwner {
    private Integer bus_owner_id;
    private String license_no;
    private String travelsname;
    private String contact_no;
    //private User user;
}
