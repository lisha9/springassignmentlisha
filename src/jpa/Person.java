package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@Column(name = "name")
	private String name;
	@Column(name = "country")
	private String country;
	@Column(name = "personid")
	private int personid;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getPersonid() {
		return personid;
	}


	public void setPersonid(int personid) {
		this.personid = personid;
	}


	@Override
	public String toString() {
		return "Person [id=" + personid + ", name=" + name + ", country=" + country + "]";
	}
}
