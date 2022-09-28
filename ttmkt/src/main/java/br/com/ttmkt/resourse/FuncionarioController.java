package br.com.ttmkt.resourse;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ttmkt.domain.Funcionario;
import br.com.ttmkt.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController   {
	
	@Autowired
	private FuncionarioService funcionarioService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Void> insert(@RequestBody Funcionario funcionario){
		
		
		funcionario = funcionarioService.cadastrar(null, null, 0, 0, null, null, null);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(funcionario.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
}
