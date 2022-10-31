package com.divups.ead.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.sql.Date;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name="specialhire_bookings")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SpecialHireEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specialbooking_id;
    @NotEmpty
    private String start;
    private String destination;
    private Integer no_of_days;
    @NotEmpty
    private Integer customer_contact;
    private Date hire_date;
    private Boolean request_status;
    private String special_notes;
    private Instant request_on;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="specialbus_id",referencedColumnName ="special_hiring_id")
    private SpecialBusEntity specialBus;
}
