package com.example.QubitsDemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repo extends CrudRepository<Feilds,Integer> {

}
