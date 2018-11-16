package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.AlunoDAO;
import dao.EmprestimoDAO;
import dao.LivroDAO;
import models.Aluno;
import models.Emprestimo;
import models.Livro;

@Controller
public class EmprestimoController {

	@RequestMapping("/emprestimo/form")
	public ModelAndView form() {
		System.out.println("chamou o form de emprestimo");
		AlunoDAO alunodao = new AlunoDAO();
		List<Aluno> listandAluno = alunodao.getLista3();
		LivroDAO livrodao = new LivroDAO();
		List<Livro> listandLivro = livrodao.getListaNemprestado();
		ModelAndView model = new ModelAndView("emprestimo/form");
		model.addObject("aluno", listandAluno);
		model.addObject("livro", listandLivro);
		return model;
	//FORMULARIO DE EMPRESTIMOS
	}

	@PostMapping("/emprestimo")
	public String adicionar(Emprestimo emprestimo, Aluno aluno) {
		EmprestimoDAO emprestimodao = new EmprestimoDAO();
		AlunoDAO alunodao = new AlunoDAO();
		emprestimodao.inserir(emprestimo);
		int b = 0;
		alunodao.alterarmd3mais(aluno.getId());
		System.out.println("adicionou o emprestimo");
		return "redirect:emprestimo";
	//ADICAO DO EMPRESTIMO. DEPOIS DE ADICIONADO ELE REDIRECIONA PARA A LISTA DE TODOS OS EMPRESTIMOS
	}
	// test

	@GetMapping("/emprestimo")
	public ModelAndView listar() {
		System.out.println("listando emprestimos");
		EmprestimoDAO emprestimodao = new EmprestimoDAO();
		List<Emprestimo> listand = emprestimodao.getLista();
		ModelAndView model = new ModelAndView("emprestimo/lista");
		model.addObject("emprestimo", listand);
		return model;
	//CONTROLLER PARA A LISTA DE TODOS OS EMPRESTIMOS
	}

	@RequestMapping("/emprestimo/devolucao")
	public String devolucao(Emprestimo emprestimo) {
		System.out.println("devolveu");
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		emprestimoDao.devolucao(emprestimo);
		return "redirect:../emprestimo";
//CONTROLLER PARA DEVOLVER OS EMPRESTIMOS
	}

	@GetMapping("/emprestimo/ativos")
	public ModelAndView listarAbertos() {
		System.out.println("listando ativos");
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		List<Emprestimo> listand = emprestimoDao.getListaAtivos();
		ModelAndView model = new ModelAndView("emprestimo/ativos");
		model.addObject("emprestimo", listand);
		return model;
//CONTROLLER PARA LISTAR TODOS OS EMPRESTIMOS ATIVOS
	}

}
