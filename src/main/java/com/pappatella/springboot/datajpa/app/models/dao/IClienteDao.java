package com.pappatella.springboot.datajpa.app.models.dao;

import java.util.List;

import com.pappatella.springboot.datajpa.app.models.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();
}
