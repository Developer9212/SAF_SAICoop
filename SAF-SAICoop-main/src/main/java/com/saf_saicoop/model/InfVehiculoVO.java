package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfVehiculoVO {
   
	private String codEmpresa;
	private String codCliente;
	private String indPropio ;
	private String marca;
	private String modelo;
	private String matricula;
	private String color;
	private Integer annoVehiculo;
	private String descripcion;
	private String incluidoPor;
	private String fecInclusion;
}
