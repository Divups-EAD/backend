package com.divups.ead.Model;

import com.divups.ead.Entity.SpecialBusEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SpecialHire {
    private Integer specialbooking_id;
    private String start;
    private String destination;
    private Integer no_of_days;
    private Integer customer_contact;
    private Date hire_date;
    private Boolean request_status;
    private String special_notes;
    private Instant request_on;
    private SpecialBusEntity specialBus;
}
