package com.digitalfactory.plotirrigationservice.model;

import com.digitalfactory.baseservice.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "plot_crop")
public class PlotCrop extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plot_crop_id_sequence")
    @SequenceGenerator(name = "plot_crop_id_sequence", sequenceName = "plot_crop_id_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plot_id", nullable = false)
    private Plot plot;

    @ManyToOne
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

    @Column(name = "plot_id", updatable = false, insertable = false)
    private Long plotId;

    @Column(name = "crop_id", updatable = false, insertable = false)
    private Long cropId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "cultivated_area")
    private BigDecimal cultivatedArea;

    @OneToMany(mappedBy = "plotCrop", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<PlotIrrigationSlot> plotIrrigationSlots = new ArrayList<>();


    public void addPlotIrrigationSlot(PlotIrrigationSlot plotIrrigationSlot) {
        plotIrrigationSlots.add(plotIrrigationSlot);
        plotIrrigationSlot.setPlotCrop(this);
    }

    public void removePlotIrrigationSlot(PlotIrrigationSlot plotIrrigationSlot) {
        plotIrrigationSlots.remove(plotIrrigationSlot);
        plotIrrigationSlot.setPlotCrop(null);
    }

}
