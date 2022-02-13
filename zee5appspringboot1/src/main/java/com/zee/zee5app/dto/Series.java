package com.zee.zee5app.dto;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.zee.zee5app.dto.Episodes;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "seriesname")}, name = "series")
public class Series  {
	
	@Id
	@Column(name = "seriesid")
	@Length(min = 6)
	private String id;
	
    @NotBlank
 
	private String seriesName;
    @NotBlank
	private String Cast;
	
    @NotNull
	private String releaseDate;
	//@NotBlank
	private String trailer;
	@NotBlank
	private String language;
	
	@Max(value = 70)
	private String ageLimit;
	
	@NotBlank
	private String genre;

	@Min(value = 1)
	private int noofepisodes;
	
	


	
	
	
	
    @OneToMany(mappedBy="series",cascade=CascadeType.ALL)
    
	private List<Episodes> episode=new ArrayList<>();
		
     
}