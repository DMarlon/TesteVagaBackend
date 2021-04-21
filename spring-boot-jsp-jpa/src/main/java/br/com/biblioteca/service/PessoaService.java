package br.com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.biblioteca.exception.RequiredFieldException;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;
import br.com.biblioteca.utils.ValidatorUtils;

@Service
public class PessoaService {

	private PessoaRepository pessoaRepository;

	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	public Pessoa salvar(Pessoa pessoa) {
		checarCamposObrigatorios(pessoa);
		return pessoaRepository.save(pessoa);
	}

	private void checarCamposObrigatorios(Pessoa pessoa) {
		if (ValidatorUtils.ehNullOuBranco(pessoa.getNome()))
			throw new RequiredFieldException("Deve ser informado um nome para a pessoa!");
		if (!ValidatorUtils.ehNullOuBranco(pessoa.getCpf()) && ValidatorUtils.ehCPFValido(pessoa.getCpf()))
			throw new RequiredFieldException("O CPF informado é inválido!");
	}

	public Optional<Pessoa> findById(Long id) {
		if (ValidatorUtils.ehNullOuMenorQueUm(id))
			Optional.empty();

		return Optional.of(pessoaRepository.findOne(id));
	}

	public List<Pessoa> getTodas() {
		return pessoaRepository.findAll();
	}

	public void deletarPorId(Long id) {
		if (!ValidatorUtils.ehNullOuMenorQueUm(id))
			pessoaRepository.deleteById(id);
	}
}
