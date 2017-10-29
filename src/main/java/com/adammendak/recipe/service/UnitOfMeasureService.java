package com.adammendak.recipe.service;

import com.adammendak.recipe.model.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasure> getAll();
    UnitOfMeasure findByDescription(String description);

}
