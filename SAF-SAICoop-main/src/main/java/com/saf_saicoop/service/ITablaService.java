package com.saf_saicoop.service;

import com.saf_saicoop.entity.Tabla;
import com.saf_saicoop.entity.TablaPK;

public interface ITablaService {

	
	public Tabla buscarPorId(TablaPK pk);

}
