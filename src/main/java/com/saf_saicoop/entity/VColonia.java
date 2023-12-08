package com.saf_saicoop.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vcolonias")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VColonia implements Serializable {
	
	 @Id
	 private Integer idcolonia; 
	 private String nombre; 
	 private Integer idmunicipio; 
	 private String codigopostal; 
	 private String municipio; 
	 private String estado; 
	 private String pais;
	 
	 private static final long serialVersionUID = 1L;

}
