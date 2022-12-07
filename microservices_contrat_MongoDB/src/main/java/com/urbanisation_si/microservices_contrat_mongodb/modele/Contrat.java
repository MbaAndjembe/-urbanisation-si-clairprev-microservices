package com.urbanisation_si.microservices_contrat_mongodb.modele;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author Patrice
 *
 */
//Début LOMBOK
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"id","numeroContrat"})
@ToString(of= {"id","numeroContrat","dateDebut","numeroAssure","numeroProduit"})
//Fin LOMBOK
// MongoDB
@Document(collection = "gestionprevdb")
public class Contrat {
	
	@Id             
	private String id;

	@NotNull 
	// MongoDB
	@Indexed(unique = true, direction = IndexDirection.DESCENDING)
	private Long numeroContrat;     
	
    @JsonFormat(pattern="yyyy-MM-dd")    
    private Date dateDebut;
    
    @NotNull    
	private Long numeroAssure;
	
    @NotNull    
	private Long numeroProduit;
	
}

