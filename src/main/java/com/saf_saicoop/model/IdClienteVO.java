package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdClienteVO {
   
	private String codEmpresa  ;
	private String codCliente  ;
	private String codTipoId   ;
	private String numId       ;
	private String fecVencim   ;
	private String indPrincipal;
}
