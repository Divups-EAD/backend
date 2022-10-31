package com.divups.ead.Entity;

import lombok.*;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "payment")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payment_id;
    private String mode;
    private Double amount;
    private Boolean updated_payment_status;
    private Instant payment_at;
    @OneToOne(fetch = LAZY)
    @JoinColumn(name="booking_id",referencedColumnName ="idbooking")
    private BookingEntity booking;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="customer_id",referencedColumnName ="user_id")
    private UserEntity user;
}
