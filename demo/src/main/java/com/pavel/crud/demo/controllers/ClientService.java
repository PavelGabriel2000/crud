package com.pavel.crud.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavel.crud.demo.dao.IClienteDao;
import com.pavel.crud.demo.models.entity.Cliente;

@Service
public class ClientService {
    @Autowired
    private IClienteDao clienteDao;

    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    public Cliente findById(Integer id) {
        return clienteDao.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client not found for this id : " + id));
    }

    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    public Cliente update(Integer id, Cliente clienteDetails) {
        Cliente cliente = findById(id);
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellido(clienteDetails.getApellido());
        return clienteDao.save(cliente);
    }

    public Cliente deleteById(Integer id) {
        Cliente cliente = findById(id);
        clienteDao.delete(cliente);
		return cliente;
    }
}
