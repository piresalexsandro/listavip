package br.com.alphapires.listavip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alphapires.listavip.model.Convidado;
import br.com.alphapires.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;
	
	public List<Convidado> listar(){
		
		return (List<Convidado>) repository.findAll();
	}

	public void salvar(Convidado convidado) {
		repository.save(convidado);
	}
}
