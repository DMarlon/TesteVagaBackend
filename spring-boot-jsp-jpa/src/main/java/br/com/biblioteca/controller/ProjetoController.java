package br.com.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.service.ProjetoService;

@Controller
public class ProjetoController {
	private ProjetoService projetoService;

	public ProjetoController(ProjetoService projetoService) {
		this.projetoService = projetoService;
	}

	@RequestMapping(value="/projeto/listar", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("tests", projetoService.getTodos());
        return "listar-projeto";
    }

	@RequestMapping(value="/projeto/adicionar", method = RequestMethod.GET)
    public String getCreate(Model model) {
		model.addAttribute("projeto", new Projeto());
        return "adicionar-projeto";
    }

	@RequestMapping(value="/pessoas/adicionar", method = RequestMethod.POST)
    public RedirectView addBook(@ModelAttribute("projeto") Projeto projeto, RedirectAttributes redirectAttributes) {
		projeto.setId(null);
        Projeto projetoSalvo = projetoService.criar(projeto);

        final RedirectView redirectView = new RedirectView("/projeto/adicionar", true);
        redirectAttributes.addFlashAttribute("projetoSalvo", projetoSalvo);
        redirectAttributes.addFlashAttribute("adicionarProjetoSuccess", true);
        return redirectView;
    }

	@RequestMapping(value="/projeto/remover/{id}", method = RequestMethod.GET)
    public RedirectView remove(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		projetoService.deletarPorId(id);

        final RedirectView redirectView = new RedirectView("/projeto/listar", true);
        redirectAttributes.addFlashAttribute("removerProjetoSuccess", true);
        return redirectView;
    }
}
