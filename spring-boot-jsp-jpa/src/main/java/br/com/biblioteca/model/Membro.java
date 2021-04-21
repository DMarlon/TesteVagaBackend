package br.com.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "membros")
public class Membro {

	public static Membro valueOf(Projeto projeto, Pessoa pessoa) {
		Membro membro = new Membro();
		membro.setProjeto(projeto);
		membro.setPessoa(pessoa);
		return membro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idprojeto", nullable = false)
	private Projeto projeto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpessoa", nullable = false)
	private Pessoa pessoa;

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
