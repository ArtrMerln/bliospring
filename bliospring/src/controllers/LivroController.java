package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.LivroDAO;
import models.Livro;

@Controller
public class LivroController {
	@RequestMapping("/livro/form")
	public String form() {
		System.out.println("chamou o form de livro");
		return "livro/form";
	}

	@PostMapping("/livro")
	public String adicionar(Livro livro) {
		System.out.println("Chamou adicionar livro");
		LivroDAO livrodao = new LivroDAO();
		livrodao.adicionar(livro);
		System.out.println("adicionou o livro");
		return "redirect:livro";

	}
	
	@GetMapping("/livro")
	public ModelAndView listar() {
		System.out.println("Chamou a listagem de livros");
		LivroDAO livroDao = new LivroDAO();
		List<Livro> lista = livroDao.getLista();
		ModelAndView model = new ModelAndView("livro/lista");
		model.addObject("livro", lista);
		return model;
	}

	@RequestMapping("/livro/remover")
	public String remover(Livro livro) {
		System.out.println("Chamou a remoção");
		LivroDAO livroDao = new LivroDAO();
		livroDao.remover(livro);
		System.out.println("removeu o livro");
		return "redirect:../livro";

}
}
