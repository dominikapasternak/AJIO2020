package com.cenzurabackend.cenzura.repository;

import com.cenzurabackend.cenzura.entity.Curse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CensureRepository extends CrudRepository<Curse,Integer> {
    List<Curse> findAll();
}
