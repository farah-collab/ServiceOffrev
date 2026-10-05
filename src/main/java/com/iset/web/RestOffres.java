package com.iset.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.iset.dao.OffreRepository;
import com.iset.entities.Offre;

@RestController
@RequestMapping("/Offres")
public class RestOffres {

	private final OffreRepository offreRepository;

	public RestOffres(OffreRepository offreRepository) {
		this.offreRepository = offreRepository;
	}

	@GetMapping
	public List<Offre> getAll() {
		return offreRepository.findAll();
	}

	// Etape 4 : consulter une offre
	@GetMapping("/{uid}")
	public Offre getbyid(@PathVariable @NonNull Long uid) {
		return offreRepository.findById(uid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Offre introuvable : " + uid));
	}

	// Etape 5 : ajouter une offre
	@PostMapping
	public Offre saveoffre(@RequestBody Offre newoffre) {
		newoffre.setCode(0); // force la creation (le code est genere par la BD)
		return offreRepository.save(newoffre);
	}

	// Modifier une offre (manquant dans l'enonce)
	@PutMapping("/{id}")
	public Offre updateoffre(@PathVariable @NonNull Long id, @RequestBody Offre o) {
		Offre existante = offreRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Offre introuvable : " + id));
		existante.setIntitule(o.getIntitule());
		existante.setSpecialite(o.getSpecialite());
		existante.setSociete(o.getSociete());
		existante.setNbpostes(o.getNbpostes());
		existante.setPays(o.getPays());
		return offreRepository.save(existante);
	}

	// Etape 6 : supprimer une offre
	@DeleteMapping("/{id}")
	public void deleteoffre(@PathVariable @NonNull Long id) {
		offreRepository.deleteById(id);
	}
}
