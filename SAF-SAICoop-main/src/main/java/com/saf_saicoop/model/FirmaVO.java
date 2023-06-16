package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirmaVO {
   
	private String codEmpresa;
	private String codCliente;
	private String indPersona;
	private String firma;
}
