package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirClienteVO {
   
	private String codEmpresa;
	private String codCliente;
	private String codDireccion;
	private String codPais;
	private String codProvincia;
	private String codCanton;
	private String codDistrito;
	private String tipDireccion;
	private String apdoPostal;
	private String codPostal;
	private String detDireccion;
	private String indEstado;
	private String numInterior;
	private String numExterior;
	private String indClasificacion;
	private String indSubClasificacion;
	private String detCalle;
	private String numPiso;
	private String tipCasa;
}
