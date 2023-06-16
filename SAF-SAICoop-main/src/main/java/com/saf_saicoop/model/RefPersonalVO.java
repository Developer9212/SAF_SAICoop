package com.saf_saicoop.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefPersonalVO {
	private String codEmpresa;
	private String codAgencia;
	private String codCliente;
	private String codUsuario;
	private Integer numRefPersonal;
	private String tipReferencia;
	private String codTipoId;
	private String nomReferente;
	private String telReferente;
	private String relPersona;
	private String puesto;
	private String lugarTrabajo;
	private String observaciones;
	private String numId;
	private String telSecundario;
	private String telOtro;
	private String nomApodo;
	private String extSecundario;
	private List<DirReferenciaVO>dirReferencias;
}
