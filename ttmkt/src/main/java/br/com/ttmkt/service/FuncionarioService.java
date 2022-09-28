package br.com.ttmkt.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ttmkt.domain.Funcionario;
import br.com.ttmkt.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funRepository;

	public Funcionario cadastrar(String nome, String sobrenome, int cpf, int telefone, String email, String cargo, LocalDate data) {
		
		
		Funcionario funcionario = new Funcionario();
		
		data = LocalDate.now();
		funcionario.setId(null);
		funcionario.setNome(nome);
		funcionario.setCargo(cargo);
		funcionario.setEmail(email);
		funcionario.setTelefone(telefone);
		
		
		return funRepository.save(funcionario);
	}
}
