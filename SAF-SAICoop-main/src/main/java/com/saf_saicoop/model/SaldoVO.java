package com.saf_saicoop.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaldoVO {

	 private String codEmpresa;
     private String codCliente;
     private Integer numLinea;
     private Integer numOperacion;
     private Integer codFactura;
     private String idOrigen;
     private String idGrupo;
     private String idSocio;
     private String idOrigenEnp;
     private String idProducto;
     private String idAuxiliar;
     private String fechaApe;
     private String elaboro;
     private String autorizo;
     private String estatus;
     private Double tasaIo;
     private Double tasaIm;
     private Double tasaIod;
     private Double montoSolicitado;
     private Double montoAutorizado;
     private Double montoPrestado;
     private String idFinalidad;
     private Integer plazo;
     private Integer periodoAbonos;
     private Double saldoInicial;
     private Double saldo;
     private Double io;
     private Double idnc;
     private Double ieco;
     private Double im;
     private String fechaActivacion;
     private String fechaUmi;
     private String idNotas;
     private Integer tipoPrestamo;
     private String cartera;
     private Integer contaIdnc;
     private Integer contaIeco;
     private Double reservaIdnc;
     private Double reservaCapital;
     private Integer tipoAmortizacion;
     private Double saldodIacum;
     private Double ivaIdncCalc;
     private Double ivaIdncPag;
     private Integer tipoReferencia;
     private Integer calificacion;
     private Integer pagosDiaFijo;
     private Double ioDif;
     private Double garantia;
     private Double saldoDiaCummi;
     private Double comision;
     private String fechasDiaCum;
     private Double prcComision;
     private Double sobrePrecio;
     private Double comisionNp;
     private Double pagosDiaUltimo;
     private Integer tipoDv;
     private String fechaSolicitud;
     private String fechaAutorizacion;
     private Double idncm;
     private Double iecom;
     private Double reservaIdncm;
     private Double tasaCatGat;
     private Double retencion;
     List<AmortizacionVO>amortizaciones;
     List<MovimientoVo>movimientos;
}
