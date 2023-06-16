package com.saf_saicoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saf_saicoop.model.InsertPFVO;
import com.saf_saicoop.service.CapaServiceGeneralImpl;

@RestController
@RequestMapping(value = "api")
public class apiController {
	
	@Autowired
	private CapaServiceGeneralImpl impl;
	
	@PostMapping(value ="personaFisica",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	private ResponseEntity<?> InsertPersonaFisica(String ogs){
		ogs = "02010110001001";
		InsertPFVO personaFisica = impl.InsertaPersonaSAF(ogs);
		
		return new ResponseEntity<>(personaFisica,HttpStatus.OK);
	}

}
