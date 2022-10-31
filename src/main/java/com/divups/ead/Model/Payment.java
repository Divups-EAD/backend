package com.divups.ead.Model;

import com.divups.ead.Entity.BookingEntity;
import com.divups.ead.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment {
    private Integer payment_id;
    private String mode;
    private Double amount;
    private Boolean updated_payment_status;
    private Instant payment_at;
    private BookingEntity booking;
    private UserEntity user;
}
