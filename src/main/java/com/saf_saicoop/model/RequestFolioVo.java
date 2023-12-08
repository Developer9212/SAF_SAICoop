package com.saf_saicoop.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestFolioVo implements Serializable{

	private Integer idorigen;
	private Integer idgrupo;
	private Integer idsocio;
	private Integer idorigenp;
	private Integer idproducto;
	private Integer idauxiliar;
	private String  fechaape;
	private Integer elaboro;
	private Integer autorizo;
	private Double estatus;
	private Double tasaio;
	private Double tasaim;
	private Double tasaiod;
	private Double montosolicitado;
	private Double montoautorizado;
	private Double montoprestado;
	private Integer idfinalidad;
	private Double plazo;
	private Double periodoabonos;
	private String fechaactivacion;
	private Integer tipoamortizacion;
	private Integer pagodiafijo;
	private Double garantia;
	private Double comision;
	private Double sobreprecio;
	private String fecha_solicitud;
	
	private static final long serialVersionUID = 1L;
}
