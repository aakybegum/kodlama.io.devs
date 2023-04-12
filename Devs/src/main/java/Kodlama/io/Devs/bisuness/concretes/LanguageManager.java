package Kodlama.io.Devs.bisuness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.bisuness.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) { //benim language ile ilgili kuralı yazabilmem için bana bir repository ver.
		
		this.languageRepository = languageRepository;
	}
	
	

	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return languageRepository.getAll();
	}


	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		if(programmingLanguage.getLanguageName()== null || programmingLanguage.getLanguageName().isEmpty()) {
			throw new Exception("Programlama dili ismi boş olamaz.");
		}
		
		if(isLanguageNameExist(programmingLanguage.getLanguageName())) { //isLanguageNameExist fonksiyonu veritabanında aynı programlama dili ismini daha önce kayıtlı olup olmadığını kontrol etmek için kullanılır.
			throw new Exception("Aynı isimde programlama dili zaten var.");
		}
		
		languageRepository.add(programmingLanguage);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		if(programmingLanguage.getLanguageName()== null || programmingLanguage.getLanguageName().isEmpty()) {
			throw new Exception("Programlama dili ismi boş olamaz.");
		}
		
		if (isLanguageNameExist(programmingLanguage.getLanguageName())) {
			throw new Exception("Aynı isimde programlama dili zaten var.");
		}
		
		languageRepository.add(programmingLanguage);
		
	}
	


	private boolean isLanguageNameExist(String languageName) {
		List<ProgrammingLanguage> allLanguages = languageRepository.getAll();
		for(ProgrammingLanguage language : allLanguages) {
			if (language.getLanguageName().equalsIgnoreCase(languageName)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ProgrammingLanguage getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
