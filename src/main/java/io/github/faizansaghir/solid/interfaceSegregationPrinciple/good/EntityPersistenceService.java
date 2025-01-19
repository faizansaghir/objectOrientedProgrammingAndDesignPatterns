package io.github.faizansaghir.solid.interfaceSegregationPrinciple.good;

import io.github.faizansaghir.solid.interfaceSegregationPrinciple.common.Entity;

import java.util.List;

public interface EntityPersistenceService<T extends Entity> {
    void save(T entity);
    T getById(Integer id);
}
