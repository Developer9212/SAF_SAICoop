package com.saf_saicoop.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertPFVO {
   
	private String codProfesion;
	private String codActividad;
	private String codSector;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String estCivil;
	private String indSexo;
	private String nomConyugue;
	private String nacionalidad;
	private String fecNacimiento;
	private String actividadEmpresarial;
	private String codEstadoNac;
	private String codMunicipioNac;
	private String tipPropiedad;
	private String codSubactiv;
	private Integer cantHijos;
	private Integer aniosAntigDomicilio;
	private Integer mesAntigDomicilio;
	private String codEmpresa;
	private String codCliente;
	private String catCliente;
	private String nomCliente;
	private String indPersona;
	private String fecIngreso;
	private String telPrincipal;
	private String telSecundario;
	private String telOtro;
	private String indRelacion;
	private Integer numGrupoFamiliar;
	private String indGrupoFamiliar;
	private String codClienteGrupoFam;
	private String indPagaIde;
	private String indPagaIsr;
	private String indPagaIva;
	private String indPagaIdePr;
	private String tipEnvio;
	private String desCorreo;
	private String indGenGrafico;
	private String nomEstado;
	private String codDireccionEst;
	private String codAgencia;
	private String codNivelCuenta;
	private String indEstado;
	private String indPerfilTransaccional;
	private String tamanoDeudor;
	private String codEjecutivo;
	private String personalidadJuridica;
	private String folioConsultaBuro;
	private String codSectorLaboral;
	private Integer numeroEmpleados;
	private String nombrecnbv;
	private Integer relacionAcreditado;
	private String tipoacreditadorelacionado;
	private String fechaUltModif;
	private String actualizado;
	private String fiel;
	private String indRelacionInstitucion;
	private String indClienteRelevante;
	private String codAgenciaCnbv;
	private String indEmproblemado;
	private String indConcursoMercantil;
	private String indOrigenAlta;
	private String indClieMyoCredit;
	private String nomApodo;
	private String extSecundario;
	private DatoAsociadoVO datoAsociado;
	private FirmaVO firma;
	private FotoVO foto;
	private List<BeneficiarioVO>beneficiarios;
	private List<ConvenioClienteVO>convenioXClientes;
	private List<DirClienteVO>dirclientes;
	private List<EmpleadoClienteVO>empleadosXClientes;
	private List<GrupoClienteVO>grupoXClientes;
	private List<IdClienteVO>idClientes;
	private List<InfVehiculoVO>infVehiculos;
	private List<IngresoEgresoVO>ingresosEgresos;
	private List<RefComercialVO>refComerciales;
	private List<RefPersonalVO>refPersonales;
	private List<VinculacionVO>vinculaciones;
}
