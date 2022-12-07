package com.urbanisation_si.microservices_contrat_tp_j3.modele;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity    
public class Contrat {
	
	@Id        
	@GeneratedValue(strategy=GenerationType.AUTO)        
	private Integer id;

	@NotNull    
	private Long numeroContrat;     
	
    @JsonFormat(pattern="yyyy-MM-dd")    
    private Date dateDebut;
    
    @NotNull    
	private Long numeroAssure;
	
    @NotNull    
	private Long numeroProduit;
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Long getNumeroContrat() {
		return numeroContrat;
	}



	public void setNumeroContrat(Long numeroContrat) {
		this.numeroContrat = numeroContrat;
	}



	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Long getNumeroAssure() {
		return numeroAssure;
	}



	public void setNumeroAssure(Long numeroAssure) {
		this.numeroAssure = numeroAssure;
	}



	public Long getNumeroProduit() {
		return numeroProduit;
	}



	public void setNumeroProduit(Long numeroProduit) {
		this.numeroProduit = numeroProduit;
	}



	/**
	 * 
	 */
	public Contrat() {
		// TODO Auto-generated constructor stub
	}

}

