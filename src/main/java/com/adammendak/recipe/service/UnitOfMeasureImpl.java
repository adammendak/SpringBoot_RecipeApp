package com.adammendak.recipe.service;

import com.adammendak.recipe.model.UnitOfMeasure;
import com.adammendak.recipe.repository.UnitOfMeasureRepository;

import java.util.Set;

public class UnitOfMeasureImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Set<UnitOfMeasure> getAll() {
        return unitOfMeasureRepository.findAll();
    }

    @Override
    public UnitOfMeasure findByDescription(String description) {
        return unitOfMeasureRepository.findByUom(description);
    }
}
