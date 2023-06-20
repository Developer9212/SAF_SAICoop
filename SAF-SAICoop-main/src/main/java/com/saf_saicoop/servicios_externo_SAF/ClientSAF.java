package com.saf_saicoop.servicios_externo_SAF;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.saf_saicoop.entity.Tabla;
import com.saf_saicoop.entity.TablaPK;
import com.saf_saicoop.model.AsientoContableVO;
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
	
	
	private String path = "https://factorajeactivo.com:8208";
	private String endPointToken = "/invoice-discount-api/v1/usuariosweb/autenticacion";
	private String endPointInsertPF= "/Client-api/v1/personasfisicas";
	private String endPointasientosContables= "/Accounting-api/v1/asientoscontables";
	Gson gson = new Gson();
	
	String token = "";
	public String token() {
		String resultado = "";
		try {
			
			TablaPK tb_pk = new TablaPK("saf","datos_token");
			Tabla tabla_token = tablaService.buscarPorId(tb_pk);
			JSONObject json = new JSONObject();
			client = new OkHttpClient().newBuilder().build();
			mediaType = MediaType.parse("application/json");
			json.put("correo",tabla_token.getDato2());
			json.put("palabraPaso", tabla_token.getDato1());
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
			
			String jsonPeticion = gson.toJson(personaFisica);
			body = RequestBody.create(mediaType,jsonPeticion);
			request = new Request.Builder()
					.url(path+endPointInsertPF)
					.method("POST", body)
					.addHeader("Content-Type","application/json")
					.addHeader("Authorization", "Bearer " + validarToken())
					//.addHeader("Accept","application/json;charset=utf-8")
					.build();
			response = client.newCall(request).execute();
			resultado = response.body().string();
			System.out.println("Resultado:"+resultado);
			
		} catch (Exception e) {
		  log.info("Error al insertar persona a SAF:"+e.getMessage());
		}
		return resultado;
	}
	
	
	public List<AsientoContableVO> asientosContables(String fechaInicio,String fechaFin) {
       List<AsientoContableVO>asientos = new ArrayList<AsientoContableVO>();
       try {
    	   
    	   client = new OkHttpClient().newBuilder().build();
    	   mediaType = MediaType.parse("text/plain");
    	   body = RequestBody.create(mediaType, "");
    	   request = new Request.Builder()
    		   .url(path+ endPointasientosContables+"?codEmpresa="+"001"+"&codAgencia="+"001"+"&fecInicio="+fechaInicio+"&fecFinal="+fechaFin)
    		   .method("GET",null)
    		   .addHeader("Authorization", "Bearer " + validarToken())
    		   .build();
    	  response = client.newCall(request).execute();
    	  String resultado = response.body().string();
    	  log.info("El resultado es :"+resultado);
	   } catch (Exception e) {
		  log.info("Error al obtener asientos contables:"+e.getMessage());
	   }
	  return asientos;
	}
	
	public String validarToken() {
		JSONObject tokenMetodo = new JSONObject();
		try {
			if(token.equals("")) {
				tokenMetodo = new JSONObject(token());
				token = tokenMetodo.getString("accessToken");
			}
		} catch (Exception e) {
		   log.info("Error al validar token:"+e.getMessage());	
		}
		return token;
	}
	
	
}
