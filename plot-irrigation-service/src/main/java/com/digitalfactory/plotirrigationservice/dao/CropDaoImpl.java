package com.digitalfactory.plotirrigationservice.dao;

import com.digitalfactory.baseservice.dao.BaseDao;
import com.digitalfactory.plotirrigationservice.dao.repo.CropRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CropDaoImpl implements CropDao {

    private final CropRepo cropRepo;
    @Override
    public CropRepo getRepository() {
        return cropRepo;
    }
}
