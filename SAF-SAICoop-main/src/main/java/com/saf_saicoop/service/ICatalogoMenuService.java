package com.saf_saicoop.service;

import org.springframework.stereotype.Service;

import com.saf_saicoop.entity.CatalogoMenu;


@Service
public interface ICatalogoMenuService {
	public CatalogoMenu buscarPorMenuOpcion(String menu,Integer opcion);
}
