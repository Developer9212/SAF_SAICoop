package com.saf_saicoop.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VinculacionVO {

	private String codEmpresa;
	private String codCliente;
	private String codVinculacion;
	private String codCltVincula;
	private String fecRegistro;
	private PersonaFisicaVO personaFisica;
	private List<DirClienteVO>dirClientes;
	private List<IdClienteVO>idClientes;
}
