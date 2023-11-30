package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngresoEgresoVO {
   
	private String codEmpresa;
	private String codCliente;
	private String indEgrIng;
	private String codTipo;
	private String concepto;
	private Double monto;
	private String codPeriocidad;
	private Double montoMensual;
	private String codUsuario;
	private String fecRegistro;
}
