package com.saf_saicoop.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestFolioVo implements Serializable{

	private String codCliente;
	private String  fechaSolicitud;
	private Double montoSolicitado;
	private Integer plazos;
	private String fechaTerminacion;
	private Integer diasOperacion;
	private Integer idUsuario;
	private Double tasa;
	
	private static final long serialVersionUID = 1L;
}
