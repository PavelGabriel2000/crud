package com.pavel.crud.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pavel.crud.demo.models.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteDaoImpl {

	@PersistenceContext
	private EntityManager em;
	
	private IClienteDao iClienteDao;
	
	
	public List<Cliente> findAll() {
		return iClienteDao.findAll();
	}

}
