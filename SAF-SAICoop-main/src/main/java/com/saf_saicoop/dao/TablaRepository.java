package com.saf_saicoop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saf_saicoop.entity.Tabla;
import com.saf_saicoop.entity.TablaPK;


public interface TablaRepository extends JpaRepository<Tabla,TablaPK> {

}
