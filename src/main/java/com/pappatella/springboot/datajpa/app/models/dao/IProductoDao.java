package com.pappatella.springboot.datajpa.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pappatella.springboot.datajpa.app.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{

	
	@Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:term%")
	public List<Producto> findByNombre(String term);
	
	public List<Producto> findByNombreLikeIgnoreCase(String term);
}
