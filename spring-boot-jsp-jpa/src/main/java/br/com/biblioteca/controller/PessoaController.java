package br.com.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.service.PessoaService;

@Controller
public class PessoaController {
	private PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@RequestMapping(value="/pessoas/listar", method = RequestMethod.GET)
    public String getTodas(Model model) {
        model.addAttribute("pessoas", pessoaService.getTodas());
        return "listar-pessoa";
    }

	@RequestMapping(value="/pessoas/adicionar", method = RequestMethod.GET)
    public String getAdicionar(Model model) {
		model.addAttribute("pessoa", new Pessoa());
        return "adicionar-pessoa";
    }

	@RequestMapping(value="/pessoas/adicionar", method = RequestMethod.POST)
    public RedirectView adicionar(@ModelAttribute("pessoa") Pessoa pessoa, RedirectAttributes redirectAttributes) {
		pessoa.setId(null);
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);

        final RedirectView redirectView = new RedirectView("/pessoas/adicionar", true);
        redirectAttributes.addFlashAttribute("pessoaSalva", pessoaSalva);
        redirectAttributes.addFlashAttribute("adicionarPessoaSuccess", true);
        return redirectView;
    }

	@RequestMapping(value="/pessoas/remover/{id}", method = RequestMethod.GET)
    public RedirectView remover(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		pessoaService.deletarPorId(id);

        final RedirectView redirectView = new RedirectView("/pessoas/listar", true);
        redirectAttributes.addFlashAttribute("removerPessoaSuccess", true);
        return redirectView;
    }
}
