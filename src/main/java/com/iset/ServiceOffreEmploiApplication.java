package com.iset;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iset.dao.OffreRepository;
import com.iset.entities.Offre;

@SpringBootApplication
public class ServiceOffreEmploiApplication implements CommandLineRunner {

	private static final String SPECIALITE_INFORMATIQUE = "informatique";

	private final OffreRepository offreRepository;

	public ServiceOffreEmploiApplication(OffreRepository offreRepository) {
		this.offreRepository = offreRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceOffreEmploiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		offreRepository.save(new Offre("Web Design", SPECIALITE_INFORMATIQUE, "AXA", 2, "France"));
		offreRepository.save(new Offre("Developpeur", SPECIALITE_INFORMATIQUE, "Talys", 3, "Tunisie"));
		offreRepository.save(new Offre("Architecte", SPECIALITE_INFORMATIQUE, "SIS", 2, "Allemagne"));
	}
}
