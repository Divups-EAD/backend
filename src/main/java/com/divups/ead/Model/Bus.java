package com.divups.ead.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bus {
    private Integer bus_id;
    private String start_point;
    private String end_point;
    private String bus_type;
    private Boolean status;
    private Integer no_of_seats;
    private Double rate;
    private Instant added_on;
    private BusOwner busOwner;
}
