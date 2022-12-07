package com.urbanisation_si.microservices_produit_tp_j3.controleur;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.urbanisation_si.microservices_produit_tp_j3.dao.ProduitRepository;
import com.urbanisation_si.microservices_produit_tp_j3.exceptions.ProduitInexistantException;
import com.urbanisation_si.microservices_produit_tp_j3.modele.Produit;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/produit")
public class ProduitControleur {
	@Autowired
	private ProduitRepository produitRepository;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(path="/rechercherNumeroProduit/{numeroProduit}")
	public Produit rechercherProduitNumeroProduit(@PathVariable Long numeroProduit) {
		
		List<Produit> produits =  produitRepository.findByNumeroProduit(numeroProduit);
		
		log.info("Liste de produits : " + produits + " "); 
		if(produits.isEmpty()) throw new ProduitInexistantException("Ce produit n'existe pas");
		
        return produits.get(0);
	}
	
	@GetMapping(path="/listerLesProduits")  
	public @ResponseBody Iterable<Produit> getAllProduits() {
		// J2 - 0
		log.info("--------------------------- Appel à getAllProduits()");
		return produitRepository.findAll();
	}

}
