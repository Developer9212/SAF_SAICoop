package com.saf_saicoop.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saf_saicoop.model.AuxiliarVO;
import com.saf_saicoop.model.Ogs;
import com.saf_saicoop.model.RequestFolioVo;
import com.saf_saicoop.model.ResponseAuxiliarVO;
import com.saf_saicoop.util.HerramientasUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "factoraje/api")
@Slf4j
public class SySDEController {
	
	
	@PostMapping(value = "/cargaAuxiliar",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	private ResponseEntity<?> cargaFolio(@RequestBody RequestFolioVo folio){
		Random random = new Random();
		int randomNumber = random.nextInt(5) + 1;
		ResponseAuxiliarVO response = new ResponseAuxiliarVO();
		try {
		
		  switch (randomNumber) {
		case 1:
			AuxiliarVO auxVo = new AuxiliarVO();			 
			  auxVo.setIdOrigen(30201);
			  auxVo.setIdGrupo(10);
			  auxVo.setIdSocio(20);
			  auxVo.setCartera("C");
			  auxVo.setEstatus("Entregado");
			  auxVo.setFechaActivacion("2023/12/13");
			  auxVo.setFechaAutorizacion("2023/12/13");
			  auxVo.setFechaAutorizacion("2023/12/13");
			  auxVo.setFechaSolicitud("2023/12/13");
			  auxVo.setIdOrigenp(20302);
			  auxVo.setIdProducto(3301);
			  auxVo.setIdAuxiliar(5);
			  auxVo.setMontoAutorizado(folio.getMontoSolicitado());
			  auxVo.setMontoPrestado(folio.getMontoSolicitado());
			  auxVo.setMontoSolicitado(folio.getMontoSolicitado());
			  auxVo.setNumPlazos(folio.getPlazos());
			  auxVo.setTasaInteresMoratorio(3.12);
			  auxVo.setTasaInteresOrdinario(0.0);
			  auxVo.setSaldo(folio.getMontoSolicitado());
			  
			  
			  response.setFolio("0203020330100000005");
			  response.setDatosFolio(auxVo);
			  response.setCodCliente("03020110000020");
			  response.setCodigo(200);
			  response.setMensaje("RESPUESTA EXITOSA");
			  
			  return new ResponseEntity<>(response,HttpStatus.OK);		
		case 2:
			response.setCodigo(400);
			response.setMensaje("Codigo cliente no existe");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		case 3:
			response.setCodigo(500);
			response.setMensaje("Falla procesar registro contacte a proveedor");
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		case 4:
			response.setCodigo(400);
			response.setMensaje("Producto no se encuentra en la base de datos");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		case 5: 
			response.setCodigo(400);
			response.setMensaje("Usuario no permitido para operar");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		  }
		
		} catch (Exception e) {
			log.info("Error al generar folio:"+e.getMessage());			
		}
		return null;
	}
}
