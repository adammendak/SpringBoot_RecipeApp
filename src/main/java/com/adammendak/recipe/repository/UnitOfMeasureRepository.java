package com.adammendak.recipe.repository;

import com.adammendak.recipe.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    UnitOfMeasure findByUom (String uom);
    Set<UnitOfMeasure> findAll();

}
