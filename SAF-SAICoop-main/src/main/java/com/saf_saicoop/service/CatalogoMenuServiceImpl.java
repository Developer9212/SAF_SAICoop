package com.saf_saicoop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.dao.MenuRepository;
import com.saf_saicoop.entity.CatalogoMenu;

@Service
public class CatalogoMenuServiceImpl implements ICatalogoMenuService{
     
	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public CatalogoMenu buscarPorMenuOpcion(String menu, Integer opcion) {
		return menuRepository.menu(menu, opcion);
	}
	

}