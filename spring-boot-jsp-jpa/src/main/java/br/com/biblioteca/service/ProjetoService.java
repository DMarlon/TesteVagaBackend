package br.com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.biblioteca.enumerator.Risco;
import br.com.biblioteca.enumerator.Status;
import br.com.biblioteca.exception.RequiredFieldException;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;
import br.com.biblioteca.utils.ValidatorUtils;

@Service
public class ProjetoService {

	private ProjetoRepository projetoRepository;

	public ProjetoService(ProjetoRepository projetoRepository) {
		this.projetoRepository = projetoRepository;
	}

	public Projeto criar(Projeto projeto) {
		checarCamposObrigatorios(projeto);
		preencherCamposIniciaisCasoNaoInformados(projeto);
		return projetoRepository.save(projeto);
	}

	private void checarCamposObrigatorios(Projeto projeto) {
		if (ValidatorUtils.ehNullOuBranco(projeto.getNome()))
			throw new RequiredFieldException("Deve ser informado um nome para a projeto!");
		if (projeto.getGerente() == null || ValidatorUtils.ehNullOuMenorQueUm(projeto.getGerente().getId()))
			throw new RequiredFieldException("Deve ser informado um gerente para o projeto!");
		if (projeto.getDataInicio() != null && projeto.getDataFim() != null && projeto.getDataInicio().isAfter(projeto.getDataFim()))
			throw new RequiredFieldException("A data de inicio do projeto não pode ser maior que a data termino!");
	}

	private void preencherCamposIniciaisCasoNaoInformados(Projeto projeto) {
		if (ValidatorUtils.ehNullOuBranco(projeto.getRisco()))
			projeto.setRisco(Risco.BAIXO.getDescription());
		if (ValidatorUtils.ehNullOuBranco(projeto.getStatus()))
			projeto.setRisco(Status.EM_ANALISE.getDescription());
	}

	public Optional<Projeto> findById(Long id) {
		if (ValidatorUtils.ehNullOuMenorQueUm(id))
			Optional.empty();

		return Optional.of(projetoRepository.findOne(id));
	}

	public List<Projeto> getTodos() {
		return projetoRepository.findAll();
	}

	public void deletarPorId(Long id) {
		if (!ValidatorUtils.ehNullOuMenorQueUm(id)) {
			Projeto projeto = projetoRepository.findOne(id);
			if (podeExcluirProjeto(projeto))
				projetoRepository.deleteById(id);
		}
	}

	private boolean podeExcluirProjeto(Projeto projeto) {
		if (projeto == null || ValidatorUtils.ehNullOuMenorQueUm(projeto.getId()))
			return false;
		if (projeto.getStatus().equals(Status.INICIANDO.getDescription()))
			return false;
		if (projeto.getStatus().equals(Status.EM_ANDAMENTO.getDescription()))
			return false;
		if (projeto.getStatus().equals(Status.ENCERRADO.getDescription()))
			return false;

		return true;
	}
}
