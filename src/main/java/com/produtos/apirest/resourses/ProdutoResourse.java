package com.produtos.apirest.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.*;

import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "/api")
public class ProdutoResourse {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto ) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto/{id}")
	public void deletaProduto(@PathVariable(value = "id") long id) {
		 produtoRepository.deleteById(id);
	}
	
	@PutMapping("/produto/{id}")
	public Produto atualizaProduto(@PathVariable(value = "id") long id, @RequestBody Produto produto) {
		 return produtoRepository.save(produto);
	}
}
