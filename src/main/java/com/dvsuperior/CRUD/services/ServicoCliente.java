package com.dvsuperior.CRUD.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dvsuperior.CRUD.entities.Cliente;
import com.dvsuperior.CRUD.repository.ClienteRepository;

@Service
public class ServicoCliente {

	private final ClienteRepository clienterepository;

	@Autowired
	public ServicoCliente(ClienteRepository clienterepository) {

		this.clienterepository = clienterepository;
	}

	public List<Cliente> buscarClientesPaginados(int pagina, int tamanhoPagina) {
		Pageable pageable = PageRequest.of(pagina, tamanhoPagina);
		Page<Cliente> clientesPaginados = clienterepository.findAll(pageable);
		return clientesPaginados.getContent();
	}

	public Cliente buscarClientePorId(Long id) {
		return clienterepository.findById(id).orElse(null);
	}

	public Cliente inserirCliente(Cliente novoCliente) {
		return clienterepository.save(novoCliente);
	}

	public Cliente atualizarCliente(Cliente clienteAtualizado) {
		return clienterepository.save(clienteAtualizado);
	}

	public boolean deletarClientePorId(Long id) {
		Optional<Cliente> clienteExistente = clienterepository.findById(id);
		if (clienteExistente.isPresent()) {
			clienterepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
