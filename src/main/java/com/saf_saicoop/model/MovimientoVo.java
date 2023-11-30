package com.saf_saicoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoVo {

	 private String codEmpresa;
     private String codCliente;
     private Integer numLinea;
     private Integer numOperacion;
     private Integer codFactura;
     private String idOrigen;
     private String idProducto;
     private String idAuxiliar;
     private String fecha;
     private Integer cargoAbono;
     private Double monto;
     private Double montoIo;
     private Double montoIm;
     private Double montoIva;
     private String idOrigEnc;
     private String periodo;
     private Integer idTipo;
     private Integer idPoliza;
     private Integer tipoMov;
     private Double saldoEc;
     private Integer transaccion;
     private Double montoIvaIm;
     private Double efectivo;
     private Integer diasVencidos;
     private Double montoVencido;
     private Integer ticket;
     private Double montoIdnc;
     private Double montoIeco;
     private Double montoIdncm;
     private Double montoIecom;
     private String cartera;
}
