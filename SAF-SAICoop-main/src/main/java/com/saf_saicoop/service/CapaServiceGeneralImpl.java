package com.saf_saicoop.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.MenuElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.entity.CatalogoMenu;
import com.saf_saicoop.entity.Colonia;
import com.saf_saicoop.entity.InsertarPF;
import com.saf_saicoop.entity.Persona;
import com.saf_saicoop.entity.PersonaPK;
import com.saf_saicoop.entity.Tabla;
import com.saf_saicoop.entity.TablaPK;
import com.saf_saicoop.model.AsientoContableVO;
import com.saf_saicoop.model.DirClienteVO;
import com.saf_saicoop.model.IdClienteVO;
import com.saf_saicoop.model.InsertPFVO;
import com.saf_saicoop.model.InsertPJVO;
import com.saf_saicoop.model.Ogs;
import com.saf_saicoop.model.SaldoVO;
import com.saf_saicoop.servicios_externo_SAF.ClientSAF;
import com.saf_saicoop.util.HerramientasUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CapaServiceGeneralImpl {
  
	@Autowired
	private ITablaService tablaService;
	@Autowired
	private IPersonaService personaService;
	@Autowired
	private ICatalogoMenuService menuService;
	@Autowired
	private IColoniaService coloniaService;
	@Autowired
	private IInsertaPFService insertaPFService;
	
	
	@Autowired
	private HerramientasUtil herramientasUtil;
	
	@Autowired
	private ClientSAF clientSAF;
	
	private String idTabla="saf";
	
	private Ogs ogs = new Ogs();
	
	public InsertarPF InsertaPersonaSAF(String ogsPet) {
		InsertPFVO inserta = new InsertPFVO();
		
		//formamos peticion
		TablaPK tbPk = new TablaPK(idTabla,"empresa");
		Tabla tablaEmpresa = tablaService.buscarPorId(tbPk);
		
		inserta.setCodEmpresa("001");
		inserta.setCodCliente(ogsPet);
		inserta.setCodProfesion("000");
		inserta.setCodActividad("00000");
		inserta.setCodSector("1");
		
		ogs = herramientasUtil.ogs(ogsPet);
		PersonaPK pkPersona = new PersonaPK(ogs.getIdorigen(),ogs.getIdgrupo(),ogs.getIdsocio());
		Persona persona = personaService.buscarPorId(pkPersona);
		
		inserta.setPrimerNombre(persona.getNombre());
		String[]listaNombre = persona.getNombre().split(" ");
		if(listaNombre[0]!=null) {
			inserta.setPrimerNombre(listaNombre[0]);
		}else if(listaNombre[1] != null) {
			inserta.setSegundoNombre(listaNombre[1]);
		}
		inserta.setPrimerApellido(persona.getAppaterno());
		inserta.setSegundoApellido(persona.getApmaterno());
		
		CatalogoMenu menu = menuService.buscarPorMenuOpcion("estadocivil",persona.getEstadocivil().intValue());	
		if(menu.getDescripcion().toUpperCase().contains("U")){
			inserta.setEstCivil("O");
		}else {
		    inserta.setEstCivil(menu.getDescripcion().substring(0,1));
		}
		menu = menuService.buscarPorMenuOpcion("sexo",persona.getSexo().intValue());
		inserta.setIndSexo(menu.getDescripcion().substring(0,1));
		inserta.setNacionalidad("1");
		inserta.setFecNacimiento(herramientasUtil.convertFechaDate(persona.getFechanacimiento()));
		inserta.setActividadEmpresarial("S");
		inserta.setCodSubactiv("00000");
		inserta.setCantHijos(0);
		inserta.setAniosAntigDomicilio(0);
		inserta.setMesAntigDomicilio(0);
		inserta.setNomCliente(persona.getNombre());
		inserta.setFecIngreso(herramientasUtil.convertFechaDate(persona.getFechaingreso()));
		inserta.setTelPrincipal(persona.getCelular());
		inserta.setTelSecundario(persona.getTelefono());
		inserta.setTelOtro(persona.getTelefonorecados());
		inserta.setIndRelacion("C");
		inserta.setNumGrupoFamiliar(0);
		inserta.setIndGrupoFamiliar("N");
		inserta.setCodClienteGrupoFam("");
		inserta.setIndPagaIde("S");
		inserta.setIndPagaIsr("S");
		inserta.setIndPagaIva("S");
		inserta.setIndPagaIdePr("S");
		inserta.setDesCorreo(persona.getEmail());
		inserta.setIndEstado("A");
		inserta.setIndPerfilTransaccional("N");
		inserta.setCodEjecutivo("SAICOOP");
		inserta.setNumeroEmpleados(0);
		inserta.setFechaUltModif(herramientasUtil.convertFechaDate(new Date()));
		inserta.setActualizado("N");
		inserta.setIndRelacionInstitucion("N");
		inserta.setIndClienteRelevante("N");
		inserta.setIndEmproblemado("N");
		inserta.setIndConcursoMercantil("N");
		inserta.setIndOrigenAlta("IM");
		inserta.setIndClieMyoCredit("N");
		if(persona.getPk().getIdgrupo().intValue() == 10) {
			inserta.setCatCliente("1");	
		}else if(persona.getPk().getIdgrupo().intValue() == 31) {
			inserta.setCatCliente("14");
		}		
		inserta.setCodAgencia("001");
		inserta.setIndPersona("F");
		
		
		List<DirClienteVO> listaDirCliente = new ArrayList<DirClienteVO>();
		DirClienteVO voDirCliente = new DirClienteVO();
		voDirCliente.setCodEmpresa(tablaEmpresa.getDato1());
		voDirCliente.setCodCliente(ogsPet);
		voDirCliente.setCodDireccion("1");
		voDirCliente.setCodPais("00");
		voDirCliente.setCodProvincia("000");
		voDirCliente.setCodCanton("00");
		voDirCliente.setCodDistrito("0000");
		voDirCliente.setTipDireccion("C");
		voDirCliente.setDetDireccion(persona.getCalle());
		voDirCliente.setIndEstado("A");
		voDirCliente.setDetCalle(persona.getEntrecalles());
		
		Colonia colonia = coloniaService.buscarPorId(persona.getIdcolonia());
		voDirCliente.setCodPostal(String.valueOf(colonia.getCodigopostal()));
		
		
		listaDirCliente.add(voDirCliente);
		inserta.setDirclientes(listaDirCliente);
		
		List<IdClienteVO>listaIdClientes = new ArrayList<IdClienteVO>();
		IdClienteVO voIdCliente = new IdClienteVO();
		
		voIdCliente.setCodEmpresa(tablaEmpresa.getDato1());
		voIdCliente.setCodCliente(ogsPet);
		
		
		voIdCliente.setCodTipoId("CURP");
		voIdCliente.setNumId(persona.getCurp());
		voIdCliente.setIndPrincipal("S");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(persona.getFechaingreso()); // Configuramos la fecha que se recibe
		calendar.add(Calendar.YEAR,10);
		
		System.out.println("Fecha vencimiento:"+calendar.getTime());
		
		voIdCliente.setFecVencim(herramientasUtil.convertFechaDate(calendar.getTime())+"T00:00:00.000Z");// "2024-12-10T09:00:00.567Z");
		listaIdClientes.add(voIdCliente);
		
		inserta.setIdClientes(listaIdClientes);
		
		
		String res = clientSAF.insertaPeronsaSAF(inserta);
		
		InsertarPF personaFisica = null;
		if(res.toUpperCase().contains(ogsPet)) {
			personaFisica = new InsertarPF();
			personaFisica.setPk(pkPersona);
			personaFisica.setFecha(new Date());
			personaFisica.setRespuesta_saf(res);
			insertaPFService.guardar(personaFisica);
		}else {
			personaFisica = new InsertarPF();
			personaFisica.setPk(pkPersona);
			personaFisica.setFecha(new Date());
			personaFisica.setRespuesta_saf("Error al registrar persona fisica :"+res);
			insertaPFService.guardar(personaFisica);
		}
		
		return personaFisica;
		
	}
	
	
	public InsertarPF InsertaPersonaSAFJ(String ogsPet) {
		InsertPJVO inserta = new InsertPJVO();
		
		//formamos peticion
		TablaPK tbPk = new TablaPK(idTabla,"empresa");
		Tabla tablaEmpresa = tablaService.buscarPorId(tbPk);
		
		inserta.setCodSector("X");
		inserta.setClaseSociedad("X");
		inserta.setCodActividad("X");
		inserta.setNomComercial(ogsPet);/**/		
		
		
		ogs = herramientasUtil.ogs(ogsPet);
		PersonaPK pkPersona = new PersonaPK(ogs.getIdorigen(),ogs.getIdgrupo(),ogs.getIdsocio());
		Persona persona = personaService.buscarPorId(pkPersona);
		
		inserta.setRazonSocial(persona.getRfc());
		inserta.setNacionalidad("1");
		inserta.setFecConstitucion("");
		inserta.setTipPropiedad("");
		inserta.setFolioActaConst("");
		inserta.setNumNotaria("");
		inserta.setNumActa("");
		inserta.setNumEscritura("");
		inserta.setCodSubactv("");
	
		
		inserta.setNomCliente(persona.getNombre());
		inserta.setFecIngreso(herramientasUtil.convertFechaDate(persona.getFechaingreso()));
		inserta.setTelPrincipal(persona.getCelular());
		inserta.setTelSecundario(persona.getTelefono());
		inserta.setTelOtro(persona.getTelefonorecados());
		inserta.setIndRelacion("C");
		inserta.setNumGrupoFamiliar(0);
		inserta.setIndGrupoFamiliar("N");
		inserta.setCodClienteGrupoFam("");
		inserta.setIndPagaIde("S");
		inserta.setIndPagaIsr("S");
		inserta.setIndPagaIva("S");
		inserta.setIndPagaIdePr("S");
		inserta.setDesCorreo(persona.getEmail());
		inserta.setIndEstado("A");
		inserta.setIndPerfilTransaccional("N");
		inserta.setCodEjecutivo("SAICOOP");
		inserta.setNumeroEmpleados(0);
		inserta.setFechaUltModif(herramientasUtil.convertFechaDate(new Date()));
		inserta.setActualizado("N");
		inserta.setIndRelacionInstitucion("N");
		inserta.setIndClienteRelevante("N");
		inserta.setIndEmproblemado("N");
		inserta.setIndConcursoMercantil("N");
		inserta.setIndOrigenAlta("IM");
		inserta.setIndClieMyoCredit("N");
		if(persona.getPk().getIdgrupo().intValue() == 10) {
			inserta.setCatCliente("1");	
		}else if(persona.getPk().getIdgrupo().intValue() == 31) {
			inserta.setCatCliente("14");
		}		
		inserta.setCodAgencia("001");
		inserta.setIndPersona("F");
		
		
		List<DirClienteVO> listaDirCliente = new ArrayList<DirClienteVO>();
		DirClienteVO voDirCliente = new DirClienteVO();
		voDirCliente.setCodEmpresa(tablaEmpresa.getDato1());
		voDirCliente.setCodCliente(ogsPet);
		voDirCliente.setCodDireccion("1");
		voDirCliente.setCodPais("00");
		voDirCliente.setCodProvincia("000");
		voDirCliente.setCodCanton("00");
		voDirCliente.setCodDistrito("0000");
		voDirCliente.setTipDireccion("C");
		voDirCliente.setDetDireccion(persona.getCalle());
		voDirCliente.setIndEstado("A");
		voDirCliente.setDetCalle(persona.getEntrecalles());
		
		Colonia colonia = coloniaService.buscarPorId(persona.getIdcolonia());
		voDirCliente.setCodPostal(String.valueOf(colonia.getCodigopostal()));
		
		
		listaDirCliente.add(voDirCliente);
		
		List<IdClienteVO>listaIdClientes = new ArrayList<IdClienteVO>();
		IdClienteVO voIdCliente = new IdClienteVO();
		
		voIdCliente.setCodEmpresa(tablaEmpresa.getDato1());
		voIdCliente.setCodCliente(ogsPet);
		
		
		voIdCliente.setCodTipoId("CURP");
		voIdCliente.setNumId(persona.getCurp());
		voIdCliente.setIndPrincipal("S");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(persona.getFechaingreso()); // Configuramos la fecha que se recibe
		calendar.add(Calendar.YEAR,10);
		
		System.out.println("Fecha vencimiento:"+calendar.getTime());
		
		voIdCliente.setFecVencim(herramientasUtil.convertFechaDate(calendar.getTime())+"T00:00:00.000Z");// "2024-12-10T09:00:00.567Z");
		listaIdClientes.add(voIdCliente);
		
		
		
		String res = clientSAF.insertaPeronsaSAJ(inserta);
		
		InsertarPF personaFisica = null;
		if(res.toUpperCase().contains(ogsPet)) {
			personaFisica = new InsertarPF();
			personaFisica.setPk(pkPersona);
			personaFisica.setFecha(new Date());
			personaFisica.setRespuesta_saf(res);
			insertaPFService.guardar(personaFisica);
		}else {
			personaFisica = new InsertarPF();
			personaFisica.setPk(pkPersona);
			personaFisica.setFecha(new Date());
			personaFisica.setRespuesta_saf("Error al registrar persona juridica :"+res);
			insertaPFService.guardar(personaFisica);
		}
		
		return personaFisica;
		
	}
	
	
	public List<AsientoContableVO>busquedaAsientosContables(String fechaInicio,String fechaFin){
		log.info("sisidjasidj");
		List<AsientoContableVO>listaAsientos = new ArrayList<AsientoContableVO>();
		try {
			listaAsientos = clientSAF.asientosContables(fechaInicio, fechaFin);			
		} catch (Exception e) {
			log.info("Error al buscar asientos contables:"+e.getMessage());
		}
		return listaAsientos;
	}
	
	public List<SaldoVO>cargaSaldos(){
		List<SaldoVO>lista = new ArrayList<>();
		try {
			lista = clientSAF.cargaSaldos();
		} catch (Exception e) {
			log.info("Error al obtener lista carga saldos:"+e.getMessage());
		}
		return lista;
	}
	
}
