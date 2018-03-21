package com.swilliams.dojoninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swilliams.dojoninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long>{

}
