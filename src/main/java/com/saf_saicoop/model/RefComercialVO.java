package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefComercialVO {
    
	private String codEmpresa;
	private String codCliente;
	private Integer numReferencia;
	private String tipReferencia; 
	private String codMoneda;
	private String nomReferente;  
	private String numCuenta;     
	private Integer monApertura;  
	private Integer salActual;    
	private String fecApertura;
	private String fecVencim;
	private String observaciones;
	private String codTipoId;
	private String numId;
}
