package br.com.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value="/", method = RequestMethod.GET)
    public String getHome(Model model) {
        return "home-teste";
    }

	@RequestMapping(value="/index", method = RequestMethod.GET)
    public String getIndex(Model model) {
        return "home-teste";
    }
}
