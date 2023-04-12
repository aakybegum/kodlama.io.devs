package Kodlama.io.Devs.bisuness.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface LanguageService {
	List<ProgrammingLanguage> getAll();
	
	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	void update(ProgrammingLanguage programmingLanguage) throws Exception;
	void delete(ProgrammingLanguage programmingLanguage);
	ProgrammingLanguage getById(int id);

}
