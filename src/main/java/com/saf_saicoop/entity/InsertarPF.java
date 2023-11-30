package com.saf_saicoop.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "respuesta_if_saf")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertarPF {	
	@Id
	private PersonaPK pk;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private String respuesta_saf;

}
