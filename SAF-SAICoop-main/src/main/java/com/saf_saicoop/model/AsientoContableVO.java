package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsientoContableVO {

	private String codEmpresa;
    private String codAgencia;
    private Integer numAsiento;
    private String tipTransaccion;
    private String subtipTransac;
    private String codSistema;
    private Integer numSecuencia;
    private String fecMovimiento;
    private String desAsiento;
    private String estAsiento;
    private String fecAsiento;
    private String fecRegistro;
    private String codUsuario;
    private String indLiquidacion;
    private String asientoOrigen;
    private String numAsientoRef;
    private String indProceso;
    private String indProcesoInterfaz;
    private String fecProcesoInterfaz;
    private String observaciones;
    
}
