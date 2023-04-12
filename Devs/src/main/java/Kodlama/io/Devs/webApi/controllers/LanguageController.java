package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.bisuness.abstracts.LanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("api/languages")
public class LanguageController {
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		
		return languageService.getAll();
		
	}
	
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		languageService.add(programmingLanguage);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		languageService.delete(programmingLanguage);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		languageService.update(programmingLanguage);
	}
	
	@GetMapping("/{id}")
	public ProgrammingLanguage getById(@PathVariable int id) {
		return languageService.getById(id);
		
	}
	
	
	
}
