package br.com.ttmkt.service;

import java.time.LocalDate;
import java.util.Optional;

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
		
		funcionario.setLocalDate(data);
		funcionario.setNome(nome);
		funcionario.setSobrenome(sobrenome);
		funcionario.setCpf(cpf);
		funcionario.setCargo(cargo);
		funcionario.setEmail(email);
		funcionario.setTelefone(telefone);
		
		return funRepository.save(funcionario);
	}

	public Funcionario getBuscarFuncionarioPorId(Integer id) {
		
		 Optional<Funcionario> optional = funRepository.findById(id);
		 if(!optional.isPresent()) {
			 return null;
		 }
		 
		 return optional.get();
	}
}
