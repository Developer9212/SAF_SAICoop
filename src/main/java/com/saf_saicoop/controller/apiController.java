package com.saf_saicoop.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.websocket.server.PathParam;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saf_saicoop.entity.InsertarPF;
import com.saf_saicoop.entity.InsertarPJ;
import com.saf_saicoop.model.AsientoContableVO;
import com.saf_saicoop.model.RequestFolioVo;
import com.saf_saicoop.service.CapaServiceGeneralImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "api")
@Slf4j
public class apiController {
	
	@Autowired
	private CapaServiceGeneralImpl impl;
	
	@GetMapping(value ="personaFisica/{ogs}")
	private ResponseEntity<?> InsertPersonaFisica(@PathVariable String ogs){
		//ogs = "02010110001001";
		String ogsValido = "";
		for(int i=0;i < ogs.length();i++) {
			if(Character.isDigit(ogs.charAt(i))) {
				 ogsValido = ogsValido + ogs.charAt(i);
			}
		}		
		InsertarPF personaFisica = impl.InsertaPersonaSAF(ogsValido.trim());
		
		return new ResponseEntity<>(personaFisica,HttpStatus.OK);
	}
	
	@GetMapping(value ="personaJuridica/{ogs}")
	private ResponseEntity<?> InsertPersonaJuridica(@PathVariable String ogs){
		//ogs = "02010110001001";
		String ogsValido = "";
		for(int i=0;i < ogs.length();i++) {
			if(Character.isDigit(ogs.charAt(i))) {
				 ogsValido = ogsValido + ogs.charAt(i);
			}
		}		
		InsertarPJ personaJuridica = impl.InsertaPersonaSAFJ(ogsValido.trim());
		
		return new ResponseEntity<>(personaJuridica,HttpStatus.OK);
	}
	
	@GetMapping(value ="/asientosContables",params = {"finicio"})
	private ResponseEntity<?> asientosContables(@RequestParam(name="finicio") String finicio,
        				                        @RequestParam(name="ffinal") String ffinal){
	    List<AsientoContableVO>asientos = impl.busquedaAsientosContables(finicio, ffinal);
	    
	    if(asientos.size() > 0) {
	    	return new ResponseEntity<>(asientos,HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<>("error al buscar asientos",HttpStatus.OK);	
	    }
		
	}
	
	@GetMapping(value ="/cargaSaldos")
	private ResponseEntity<?> cargaSaldos(){
	    return new ResponseEntity<>(impl.cargaSaldos(),HttpStatus.OK);	
	}
	
	@PostMapping(value = "cargaAuxiliar",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	private ResponseEntity<?> cargaFolio(@RequestBody RequestFolioVo folio){
		
		return null;
		
	}
		
	



}
