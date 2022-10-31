package com.divups.ead.Model;

import com.divups.ead.Entity.PaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CardDetails {
    private Integer id;
    private String cardholders_name;
    private Integer card_no;
    private Date expiry_date;
    private Integer emv_no;
    private Boolean cardpayment_status;
    private Instant card_payment_at;
    private PaymentEntity payment;
}
