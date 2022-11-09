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
    private String seat_no;
    private Integer customer_id;
    private Date booking_date;
    private Integer busid;



}
