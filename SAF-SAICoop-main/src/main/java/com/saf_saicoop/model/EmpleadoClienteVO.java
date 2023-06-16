package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoClienteVO {
   
	private String codEmpresa;
	private String codAgencia;
	private String codCliente;
	private Integer anio;
	private Integer total;
	private String descripcion;
	private String incluidoPor;
	private String fecInclusion;
	private String modificadoPor;
	private String fecModificacion;
}
