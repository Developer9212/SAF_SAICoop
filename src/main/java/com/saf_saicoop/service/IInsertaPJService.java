package com.saf_saicoop.service;

import com.saf_saicoop.entity.InsertarPJ;
import com.saf_saicoop.entity.PersonaPK;

public interface IInsertaPJService {
	public InsertarPJ buscarPorId(PersonaPK id);
	public InsertarPJ guardar(InsertarPJ personaJuridica);
}
