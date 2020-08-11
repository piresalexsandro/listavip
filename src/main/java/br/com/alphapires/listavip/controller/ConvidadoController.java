package br.com.alphapires.listavip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alphapires.enviadorEmail.service.EmailService;
import br.com.alphapires.listavip.model.Convidado;
import br.com.alphapires.listavip.repository.ConvidadoRepository;
import br.com.alphapires.listavip.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService service;


	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {

		List<Convidado> convidados = service.listar();

		model.addAttribute("convidados", convidados);
			
		return "listaconvidados";
	}

	@RequestMapping(value="salvar", method=RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {

		Convidado convidado = new Convidado();
		convidado.setNome(nome);
		convidado.setEmail(email);
		convidado.setTelefone(telefone);

		service.salvar(convidado);
		
		new EmailService().enviar(nome, email);

		return listaConvidados(model);
	}
	
}
