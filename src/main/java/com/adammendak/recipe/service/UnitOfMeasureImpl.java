package com.adammendak.recipe.service;

import com.adammendak.recipe.model.UnitOfMeasure;
import com.adammendak.recipe.repository.UnitOfMeasureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class UnitOfMeasureImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    Logger logger = LoggerFactory.getLogger(UnitOfMeasureImpl.class);

    public UnitOfMeasureImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Set<UnitOfMeasure> getAll() {

        logger.debug("I'm in unitOfMeasuerImpl");
        return unitOfMeasureRepository.findAll();
    }

    @Override
    public UnitOfMeasure findByDescription(String description) {
        return unitOfMeasureRepository.findByUom(description);
    }


}
