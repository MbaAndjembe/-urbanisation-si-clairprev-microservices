package com.urbanisation_si.microservices_contrat_mongodb.controleur;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanisation_si.microservices_contrat_mongodb.dao.ContratRepository;
import com.urbanisation_si.microservices_contrat_mongodb.exceptions.*;
import com.urbanisation_si.microservices_contrat_mongodb.modele.Contrat;

@RestController
@RequestMapping(path="/contrat")
public class ContratControleur {
	@Autowired
	private ContratRepository contratRepository;
	
    @PostMapping (path="/creer")
    public ResponseEntity<Contrat> creerContrat(@Valid @RequestBody Contrat contrat) {
    	Contrat nouveauContrat = contratRepository.save(contrat);

        if(nouveauContrat == null) throw new CreationContratImpossibleException("Impossible de créer le contrat.");

        return new ResponseEntity<Contrat>(nouveauContrat, HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/rechercherId/{id}")
    public Optional<Contrat> rechercherContratId(@PathVariable String id) {

        Optional<Contrat> contrat = contratRepository.findById(id);

        if(!contrat.isPresent()) throw new ContratInexistantException("Ce contrat n'existe pas");

        return contrat;
    }
    
	@GetMapping(path="/rechercherNumeroContrat/{numeroContrat}")
	public List<Contrat> rechercherContratNumeroContrat(@PathVariable Long numeroContrat) {
		
		List<Contrat> contrats =  contratRepository.findByNumeroContrat(numeroContrat);
		
        if(contrats.isEmpty()) throw new ContratInexistantException("Ce contrat n'existe pas");

        return contrats;
	}
	
	@GetMapping(path="/rechercherNumeroAssure/{numeroAssure}")
	public List<Contrat> rechercherContratNumeroAssure(@PathVariable Long numeroAssure) {
		
		List<Contrat> contrats =  contratRepository.findByNumeroAssure(numeroAssure);
		
        if(contrats.isEmpty()) throw new ContratInexistantException("Ce contrat n'existe pas");

        return contrats;
	}
    
	@GetMapping(path="/rechercherNumeroProduit/{numeroProduit}")
	public List<Contrat> rechercherContratNumeroProduit(@PathVariable Long numeroProduit) {
		
		List<Contrat> contrats =  contratRepository.findByNumeroProduit(numeroProduit);
		
        if(contrats.isEmpty()) throw new ContratInexistantException("Ce contrat n'existe pas");

        return contrats;
	}
	
	/**
	 * 
	 */
	public ContratControleur() {
		// TODO Auto-generated constructor stub
	}

}

