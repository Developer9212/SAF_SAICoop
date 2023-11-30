package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiarioVO {

	private String codEmpresa;
	private String codCliente;
	private Integer numSecuencia;
	private String nomBeneficiario;
	private String parentesco;
	private Integer prioridad;
}
