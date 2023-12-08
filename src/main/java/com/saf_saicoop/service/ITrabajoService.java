package com.saf_saicoop.service;

import com.saf_saicoop.entity.PersonaPK;
import com.saf_saicoop.entity.Trabajo;

public interface ITrabajoService {
   
	public Trabajo buscarPorId(PersonaPK pk);
}
