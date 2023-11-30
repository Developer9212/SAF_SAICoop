package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatoAsociadoVO {
 
	private String codEmpresa;
	private String codCliente;
	private String indEstado;
	private String fechIngreso;
	private String fechInactivacion;
	private String fechRenuncia;
	private String codMotRenuncia;
	private String codPlanilla;
	private String tipAsociado;
	private String lugarTrabajo;
	private String tipTrabajo;
	private Integer salario;
	private Integer cantDependientes;
	private String dirTrabajo;
	private String nomBeneficiario;
	private String relacBeneficiario;
	private String fechNacimiento;
	private Integer numSesion;
	private Integer numArticulo;
	private String tipoUnion;
	private String tipoPlanilla;
	private String tipIngreso;
	private String nomEmpresaLaboral;
	private String nomAreaLaboral;
	private String nomPuestoLaboral;
	private String nomDepartamentoLaboral;

}
