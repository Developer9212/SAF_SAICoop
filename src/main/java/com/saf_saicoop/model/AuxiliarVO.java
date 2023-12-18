package com.saf_saicoop.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuxiliarVO implements Serializable{

	 private Integer idOrigen; 
	 private Integer idGrupo; 
	 private Integer idSocio; 
	 private Integer idOrigenp; 
	 private Integer idProducto; 
	 private Integer idAuxiliar; 
	 private String fechaApertura; 
	 private String estatus; 
	 private Double tasaInteresOrdinario;
	 private Double tasaInteresMoratorio;
	 private Double montoSolicitado;
	 private Double montoAutorizado;
	 private Double montoPrestado;
	 private Integer numPlazos; 
	 private Double saldo;
	 private String fechaActivacion; 
	 private String cartera;
	 private String fechaSolicitud; 
	 private String fechaAutorizacion; 

	 private static final long serialVersionUID = 1L;

}
