package com.dvsuperior.CRUD.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperior.CRUD.entities.Cliente;
import com.dvsuperior.CRUD.services.ServicoCliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ServicoCliente servicocliente;

	@Autowired
	public ClienteController(ServicoCliente servicocliente) {

		this.servicocliente = servicocliente;
	};

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
		Cliente cliente = servicocliente.buscarClientePorId(id);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> buscarClientesPaginados(@RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "10") int tamanhoPagina) {

		List<Cliente> clientes = servicocliente.buscarClientesPaginados(pagina, tamanhoPagina);
		return ResponseEntity.ok(clientes);
	}

	@PostMapping
	public ResponseEntity<Cliente> inserirCliente(@RequestBody Cliente novoCliente) {
		Cliente clienteInserido = servicocliente.inserirCliente(novoCliente);
		return ResponseEntity.ok(clienteInserido);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
		clienteAtualizado.setId(id);
		Cliente clienteAtualizadoResult = servicocliente.atualizarCliente(clienteAtualizado);

		if (clienteAtualizadoResult != null) {
			return ResponseEntity.ok(clienteAtualizadoResult);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarClientePorId(@PathVariable Long id) {
		boolean clienteDeletado = servicocliente.deletarClientePorId(id);
		if (clienteDeletado) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
