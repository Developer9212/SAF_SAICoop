package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmortizacionVO {
   
	private String codEmpresa;
    private String codCliente;
    private Integer numLinea;
    private Integer numOperacion;
    private Integer codFactura;
    private String idOrigen;
    private String idProducto;
    private String idAuxiliar;
    private Integer idAmortizacion;
    private String vence;
    private Double abono;
    private Double io;
    private Double abonoPag;
    private Double ioPag;
    private boolean bonificado;
    private boolean pagoVariable;
    private boolean todoPag;
    private boolean atiempo;
    private Integer bonificacion;
    private Integer anualidad;
    private String diasVencidos;
}
