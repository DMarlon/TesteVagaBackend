package br.com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.biblioteca.exception.RequiredFieldException;
import br.com.biblioteca.model.Membro;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.MembroRepository;
import br.com.biblioteca.utils.ValidatorUtils;

@Service
public class MembroService {

	private MembroRepository memboRepository;
	private ProjetoService projetoService;
	private PessoaService pessoaService;

	public MembroService(MembroRepository memboRepository, ProjetoService projetoService, PessoaService pessoaService) {
		this.memboRepository = memboRepository;
		this.projetoService = projetoService;
		this.pessoaService = pessoaService;
	}

	public Membro add(Projeto projeto, Pessoa integrante) {
		checarCamposObrigatorios(projeto, integrante);

		Optional<Projeto> projetoCompleto = projetoService.findById(projeto.getId());
		Optional<Pessoa> integranteCompleto = pessoaService.findById(integrante.getId());

		verificarProjeto(projetoCompleto);
		verificarIntegrante(integranteCompleto);


		return memboRepository.save(Membro.valueOf(projetoCompleto.get(), integranteCompleto.get()));
	}

	private void checarCamposObrigatorios(Projeto projeto, Pessoa integrante) {
		if (projeto == null || ValidatorUtils.ehNullOuMenorQueUm(projeto.getId()))
			throw new RequiredFieldException("Deve ser informado o id de um projeto válido!");
		if (integrante == null || ValidatorUtils.ehNullOuMenorQueUm(integrante.getId()))
			throw new RequiredFieldException("Deve ser informado o id de um integrante válido!");
	}

	private void verificarProjeto(Optional<Projeto> projeto) {
		if (projeto.isEmpty())
			throw new RequiredFieldException("Deve ser informado um projeto válido!");
	}

	private void verificarIntegrante(Optional<Pessoa> pessoa) {
		if (pessoa.isEmpty())
			throw new RequiredFieldException("Deve ser informado um integrante válido!");
		if (!pessoa.get().getFuncionario())
			throw new RequiredFieldException("Apenas funcionário podem integrar um time!");
	}

	public List<Membro> getTodos(Long projectId) {
		return memboRepository.findByProjectId(projectId);
	}

	public void deletarIntegrante(Long projetoId, Long pessoaId) {
		if (!ValidatorUtils.ehNullOuMenorQueUm(pessoaId))
			memboRepository.deleteByProjetoIdAndPessoaId(projetoId, pessoaId);
	}
}
