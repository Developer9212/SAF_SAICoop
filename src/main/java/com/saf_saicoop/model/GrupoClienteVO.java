package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoClienteVO {
   
	private String codEmpresa;
	private String codAgencia;
	private String codCliente;
	private String codGrupo;
	private String indGrado;
	private String fecRegistro;
}
