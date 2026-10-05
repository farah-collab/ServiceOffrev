package com.iset.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.iset.entities.Offre;

// Spring Data REST expose automatiquement ce repository sur /rest-offres
// (GET, POST, PUT, PATCH, DELETE) sans ecrire de controleur.
@RepositoryRestResource(path = "rest-offres", collectionResourceRel = "offres")
public interface OffreRepository extends JpaRepository<Offre, Long> {

	// Exposee sur : GET /rest-offres/search/parPays?pays=Tunisie
	@RestResource(path = "parPays")
	List<Offre> findByPays(@Param("pays") String pays);
}
