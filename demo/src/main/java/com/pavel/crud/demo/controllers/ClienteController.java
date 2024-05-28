package com.pavel.crud.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pavel.crud.demo.models.entity.Cliente;


@RestController
public class ClienteController {
	
	@Autowired
	private ClientService clientService;
	

	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public List<Cliente> getClientes(){
		return clientService.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Cliente> deleteById(@PathVariable Integer id) {
		Cliente cliente = clientService.deleteById(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
		
		Cliente cliente = clientService.findById(id);
		
		return ResponseEntity.ok().body(cliente); 
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Cliente> updateClienteById(@PathVariable Integer id, @RequestBody Cliente cliente){
		Cliente newClient = clientService.update(id, cliente);
		return ResponseEntity.ok().body(newClient);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Cliente> createCliente(@Validated @RequestBody Cliente cliente) {
		
		Cliente savedCliente = clientService.save(cliente);
		
		return ResponseEntity.ok().body(savedCliente);
	}
	

}
