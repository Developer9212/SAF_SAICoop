package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AstoDetalleVO {
    
	private String codEmpresa;
     private String codAgencia;
     private Integer numAsiento;
     private Integer numLinea;
     private String cuentaContable;
     private String cuentaContableHomologada;
     private String fecMovimiento;
     private Double debito;
     private Double credito;
     private Double debitoCta;
     private Double creditoCta;
     private String detalle;
     private Double tipCamBase;
     private Double tipCamCta;
     private String referencia;
     private String codUnidad;
}
