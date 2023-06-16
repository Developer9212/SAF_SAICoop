package com.saf_saicoop.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class TablaPK implements Serializable{
    
	private String idtabla;
	private String idelemento;
	
	private static final long serialVersionUID = 1L;
}
