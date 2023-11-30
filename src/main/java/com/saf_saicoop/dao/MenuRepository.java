package com.saf_saicoop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.saf_saicoop.entity.CatalogoMenu;

public interface MenuRepository extends JpaRepository<CatalogoMenu,String>{
    
	@Query(value = " SELECT * FROM catalogo_menus WHERE menu =?1 AND opcion =?2",nativeQuery = true)
	public CatalogoMenu menu(String menu,Integer opcion);
	
}
