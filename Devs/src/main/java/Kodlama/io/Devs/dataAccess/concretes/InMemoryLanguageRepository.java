package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<ProgrammingLanguage> programminglanguages;
	
	public InMemoryLanguageRepository() { //constructor
		programminglanguages = new ArrayList<ProgrammingLanguage>();
		programminglanguages.add(new ProgrammingLanguage(1, "C#"));
		programminglanguages.add(new ProgrammingLanguage(2, "Java"));
		programminglanguages.add(new ProgrammingLanguage(3, "Python"));
		
	}
	
	
	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programminglanguages;
	}




	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		if (programmingLanguage != null && !isLanguageNameExist(programmingLanguage.getLanguageName())) {
			programmingLanguage.setId(programminglanguages.size()+1);
			programminglanguages.add(programmingLanguage);
			
		}
	}




	private boolean isLanguageNameExist(String languageName) {
	    for (ProgrammingLanguage language : programminglanguages) {
	        if (language.getLanguageName().equalsIgnoreCase(languageName)) {
	            return true;
	        }
	    }
	    return false;
	}


	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		if (programmingLanguage != null) {
			programminglanguages.remove(programmingLanguage);
		}
	}




	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		int index = getLanguageIndexById(programmingLanguage.getId());
		if (index >= 0) {
			programminglanguages.set(index, programmingLanguage);
		}
		
	}




	private int getLanguageIndexById(int id) {
		for (int i = 0; i < programminglanguages.size(); i++) {
            if (programminglanguages.get(i).getId() == id) {
                return i;
            }
        }
		return -1;
	}


	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage language : programminglanguages) {
            if (language.getId() == id) {
                return language;
            }
		}
		return null;
	}
}
