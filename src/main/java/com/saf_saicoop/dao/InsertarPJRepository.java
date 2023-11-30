package com.saf_saicoop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saf_saicoop.entity.InsertarPJ;
import com.saf_saicoop.entity.PersonaPK;

public interface InsertarPJRepository extends JpaRepository<InsertarPJ, PersonaPK>{

}
