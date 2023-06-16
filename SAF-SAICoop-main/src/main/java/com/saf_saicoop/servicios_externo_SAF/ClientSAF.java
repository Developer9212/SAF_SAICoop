package com.saf_saicoop.servicios_externo_SAF;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.entity.Tabla;
import com.saf_saicoop.entity.TablaPK;
import com.saf_saicoop.model.InsertPFVO;
import com.saf_saicoop.service.ITablaService;

import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
@Service
public class ClientSAF {
	
	@Autowired
	private ITablaService tablaService;
	
	OkHttpClient client = null;
	MediaType mediaType = null;
	RequestBody body = null;
	Request request = null;
	Response response = null;
	JSONObject json = new JSONObject();
	
	private String path = "https://factorajeactivo.com:8208";
	private String endPointToken = "/invoice-discount-api/v1/usuariosweb/autenticacion";
	
	String token = "";
	public String token() {
		String resultado = "";
		try {
			
			TablaPK tb_pk = new TablaPK("saf-saicoop","datos-token");
			Tabla tabla_token = tablaService.buscarPorId(tb_pk);
			
			client = new OkHttpClient().newBuilder().build();
			mediaType = MediaType.parse("application/json");
			json.put("correo",tabla_token.getDato1());
			json.put("palabraPaso", tabla_token.getDato2());
			body = RequestBody.create(mediaType,json.toString());
			request = new Request.Builder()
					.url(path+endPointToken)
					.method("POST", body).addHeader("Content-Type", "application/json").build();
			response = client.newCall(request).execute();
			resultado = response.body().string();
		} catch (Exception e) {
			log.info("Error al obtener token:"+e.getMessage());
		}
		return resultado;
	}
	
	public String insertaPeronsaSAF(InsertPFVO personaFisica) {
		String resultado = "";
		try {
			client = new OkHttpClient().newBuilder().build();
			mediaType = MediaType.parse("application/json");
			//json.put("correo",tabla_token.getDato1());
			//json.put("palabraPaso", tabla_token.getDato2());
			body = RequestBody.create(mediaType,json.toString());
			request = new Request.Builder()
					.url(path+endPointToken)
					.method("POST", body)
					.addHeader("Content-Type", "application/json")
					 .addHeader("Authorization", "Bearer" + validarToken())
					.build();
			response = client.newCall(request).execute();
			resultado = response.body().string();
		} catch (Exception e) {
		  System.out.println("Error al insertar persona a SAF:"+e.getMessage());
		}
		return resultado;
	}
	
	public String validarToken() {
		String tokenValido = "";
		try {
			if(token.equals("")) {
				tokenValido = token();
			}else {
				tokenValido = token;
			}
		} catch (Exception e) {
		  System.out.println("Error al validar token:"+e.getMessage());	
		}
		return tokenValido;
	}
	
	
}
