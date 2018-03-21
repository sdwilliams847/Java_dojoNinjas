package com.swilliams.dojoninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swilliams.dojoninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo,Long>{

}
