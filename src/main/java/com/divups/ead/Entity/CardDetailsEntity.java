package com.divups.ead.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.sql.Date;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "card_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CardDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Card Holder's name is required")
    private String cardholders_name;
    @NotBlank(message = "Credit card number is required")
    private Integer card_no;
    @NotEmpty
    private Date expiry_date;
    @NotBlank(message = "EMV security number is required")
    private Integer emv_no;
    private Boolean cardpayment_status;
    private Instant card_payment_at;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="payment_id",referencedColumnName ="payment_id")
    private PaymentEntity payment;
}
