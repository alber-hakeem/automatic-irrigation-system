package com.digitalfactory.plotirrigationservice.model;


import com.digitalfactory.automaticirrigationsystem.enums.IrrigationStatus;
import com.digitalfactory.baseservice.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "plot_irrigation_slot")
public class PlotIrrigationSlot extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plot_irrigation_slot_id_sequence")
    @SequenceGenerator(name = "plot_irrigation_slot_id_sequence", sequenceName = "plot_irrigation_slot_id_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plot_crop_id")
    private PlotCrop plotCrop;


    @Column(name="irrigation_date")
    private LocalDateTime irrigationDate;

    @Column(name="irrigation_start_time")
    private LocalTime irrigationStartTime;

    @Column(name="irrigation_end_time")
    private LocalTime irrigationEndTime;

    @Column(name="amount_of_water")
    private BigDecimal amountOfWater;


    @Column(name = "irrigation_status")
    @Enumerated(EnumType.STRING)
    private IrrigationStatus irrigationStatus;


}