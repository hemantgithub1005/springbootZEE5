package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "episodename")}, name = "episodes")
public class Episodes implements Comparable<Movie> {
	
	@Id
	@Column(name = "episodesid")
	@Length(min = 6)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@NotBlank
	private String episodename;
	
	private int length;
	
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	@ManyToOne
	@JoinColumn(name="seriesid")//fk
    private Series series; //take series id and act as fk
}