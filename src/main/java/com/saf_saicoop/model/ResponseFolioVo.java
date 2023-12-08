package com.saf_saicoop.model;

import java.util.List;

import lombok.Data;

@Data
public class ResponseFolioVo {
	
	private String folioGenerado;
	private String fechaApertura;
	private String codigoCliente;
	private List<AmortizacionVO>amortizaciones;

}
