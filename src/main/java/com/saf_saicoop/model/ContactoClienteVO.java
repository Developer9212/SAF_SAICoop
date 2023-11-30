package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactoClienteVO {
    
	private String codEmpresa;
	private String codCliente;
	private Integer numContacto;
	private String nomContacto;
	private String idContacto;
	private String puestoContacto;
	private String telContacto;
	private String poderContacto;
	private String observaciones;
	private String calidades;
}
