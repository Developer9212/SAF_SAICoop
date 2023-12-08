package com.saf_saicoop.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertPJVO {
   
	private String codSector;
	private String claseSociedad;
	private String codActividad;
	private String nomComercial;
	private String razonSocial;
	private String nacionalidad;
	private String fecConstitucion;
	private String tipPropiedad;
	private String folioActaConst;
	private String numNotaria;
	private String numActa;
	private String numEscritura;
	private String codSubactv;
	private String indOrganDescen;
	private String lei;
	private String codEmisionTituloDeuda;
	private String indEntidadGubernamental;
	
	private List<ContactoClienteVO>contactoXCliente;
	
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
	private List<DirClienteVO>dirClientes;
	private List<EmpleadoClienteVO>empleadosXCliente;
	private List<GrupoClienteVO>grupoXClientes;
	private List<IdClienteVO>idClientes;
	private List<InfVehiculoVO>infVehiculos;
	private List<IngresoEgresoVO>ingresosEgresos;
	private List<RefComercialVO>refComerciales;
	private List<RefPersonalVO>refPersonales;	
	private List<VinculacionVO>vinculaciones;
	
	
	
	
	
	
}
