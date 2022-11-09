package com.divups.ead.Model;

import com.divups.ead.Entity.BusEntity;
import com.divups.ead.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Booking {
    private Integer idbooking;
    private String seat_no;
    private Date booking_date;
    private Integer busid;
    private Integer customer_id;

}
