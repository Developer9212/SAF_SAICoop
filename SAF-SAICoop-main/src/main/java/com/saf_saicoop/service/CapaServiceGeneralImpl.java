package com.saf_saicoop.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.entity.CatalogoMenu;
import com.saf_saicoop.entity.Persona;
import com.saf_saicoop.entity.PersonaPK;
import com.saf_saicoop.entity.Tabla;
import com.saf_saicoop.entity.TablaPK;
import com.saf_saicoop.model.DirClienteVO;
import com.saf_saicoop.model.IdClienteVO;
import com.saf_saicoop.model.InsertPFVO;
import com.saf_saicoop.model.Ogs;
import com.saf_saicoop.util.HerramientasUtil;

@Service
public class CapaServiceGeneralImpl {
  
	@Autowired
	private ITablaService tablaService;
	@Autowired
	private IPersonaService personaService;
	@Autowired
	private ICatalogoMenuService menuService;
	
	
	
	@Autowired
	private HerramientasUtil herramientasUtil;
	
	
	private String idTabla="saf";
	
	private Ogs ogs = new Ogs();
	
	public InsertPFVO InsertaPersonaSAF(String ogsPet) {
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
		inserta.setEstCivil(menu.getDescripcion());
		menu = menuService.buscarPorMenuOpcion("sexo",persona.getSexo().intValue());
		inserta.setIndSexo(menu.getDescripcion().substring(0));
		inserta.setNacionalidad("1");
		inserta.setFecNacimiento(herramientasUtil.convertFechaDate(persona.getFechanacimiento()));
		inserta.setActividadEmpresarial("S");
		inserta.setCodSubactiv("00000");
		inserta.setCantHijos("0");
		inserta.setAniosAntigDomicilio("0");
		inserta.setMesAntigDomicilio("0");
		inserta.setNomCliente("");
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
		
		List<DirClienteVO> listaDirCliente = new ArrayList<DirClienteVO>();
		DirClienteVO voDirCliente = new DirClienteVO();
		voDirCliente.setCodEmpresa(tablaEmpresa.getDato1());
		voDirCliente.setCodCliente(ogsPet);
		voDirCliente.setCodDireccion("402");
		voDirCliente.setCodPais("00");
		voDirCliente.setCodProvincia("000");
		voDirCliente.setCodCanton("00");
		voDirCliente.setCodDistrito("0000");
		voDirCliente.setTipDireccion("C");
		voDirCliente.setDetDireccion(persona.getCalle());
		voDirCliente.setIndEstado("A");
		voDirCliente.setDetCalle(persona.getEntrecalles());
		
		listaDirCliente.add(voDirCliente);
		inserta.setDirclientes(listaDirCliente);
		
		List<IdClienteVO>listaIdClientes = new ArrayList<IdClienteVO>();
		IdClienteVO voIdCliente = new IdClienteVO();
		
		voIdCliente.setCodEmpresa(tablaEmpresa.getDato1());
		voIdCliente.setCodCliente(ogsPet);
		voIdCliente.setCodTipoId("CURP");
		voIdCliente.setNumId(persona.getCurp());
		voIdCliente.setIndPrincipal("S");
		listaIdClientes.add(voIdCliente);
		
		inserta.setIdClientes(listaIdClientes);
		
		
		
		
		
		
		
		return inserta;
		
	}
	
	
	
}
