package com.saf_saicoop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class ResponseAuxiliarVO implements Serializable{
    
	private Integer codigo;
	 @JsonInclude(value = Include.NON_NULL)
	private String folio;
	 @JsonInclude(value = Include.NON_NULL)
	private String codCliente;
	 @JsonInclude(value = Include.NON_NULL)
	private AuxiliarVO datosFolio;
	private String mensaje;
	private static final long serialVersionUID = 1L;
	
}
