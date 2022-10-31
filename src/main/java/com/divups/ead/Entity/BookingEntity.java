package com.divups.ead.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "booking")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idbooking;
    @NotEmpty
    private Integer seat_no;
    // ride date
    @NotBlank(message = "Date for ride is required")
    private Date booking_date;
    //ride time
    @NotBlank(message = "Time for ride is required")
    private Time booking_time;
    private Boolean payment_status;
    private Instant booking_at;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="busid",referencedColumnName ="bus_id")
    private BusEntity bus;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="customer_id",referencedColumnName ="user_id")
    private UserEntity user;

}
