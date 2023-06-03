package com.digitalfactory.plotirrigationservice.dao.repo;

import com.digitalfactory.plotirrigationservice.model.PlotCrop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlotCropRepo extends JpaRepository<PlotCrop,Long> {

}

