package com.digitalfactory.plotirrigationservice.dao.repo;

import com.digitalfactory.plotirrigationservice.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CropRepo extends JpaRepository<Crop,Long> {
}
