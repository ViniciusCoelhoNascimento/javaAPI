package controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.AllArgsConstructor;
import models.AlunoModel;
import repositories.AlunoRepository;


@RestController
@RequestMapping("/alunos")
@CrossOrigin("*")
@AllArgsConstructor
public class AlunoController {
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public ResponseEntity<List<AlunoModel>> getAllAlunos(){
		return new ResponseEntity<>(alunoRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<AlunoModel> createNewAluno(@RequestBody AlunoModel newAluno){
		newAluno.setId(null);
		return new ResponseEntity<>(alunoRepository.save(newAluno), HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<AlunoModel> updateAluno(@RequestBody AlunoModel newAluno){
		return new ResponseEntity<>(alunoRepository.save(newAluno), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteAluno(@PathVariable Integer id){
		alunoRepository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
