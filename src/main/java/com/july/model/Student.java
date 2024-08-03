package com.july.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;






@Entity
@Table(name = "student_data")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Sport> sports;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ExtraActivity> extraActivity;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<AcedemicResult> acResults;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	public List<ExtraActivity> getExtraActivity() {
		return extraActivity;
	}

	public void setExtraActivity(List<ExtraActivity> extraActivity) {
		this.extraActivity = extraActivity;
	}

	public List<AcedemicResult> getAcResults() {
		return acResults;
	}

	public void setAcResults(List<AcedemicResult> acResults) {
		this.acResults = acResults;
	}

	
	
}
