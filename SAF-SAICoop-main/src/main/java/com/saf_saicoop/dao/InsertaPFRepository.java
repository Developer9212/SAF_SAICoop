package com.saf_saicoop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saf_saicoop.entity.InsertarPF;
import com.saf_saicoop.entity.PersonaPK;

public interface InsertaPFRepository extends JpaRepository<InsertarPF,PersonaPK> {

	
}
