package com.pavel.crud.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pavel.crud.demo.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Integer>{
	
}
