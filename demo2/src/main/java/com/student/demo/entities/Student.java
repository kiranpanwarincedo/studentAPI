package com.example.demo.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    
    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "section", nullable = false)
    private String section;
    
    @Column(name = "rank", nullable = false)
    private int rank;

	public Student(Long id, String subject, String section, int rank) {
		super();
		this.id = id;
		this.subject = subject;
		this.section = section;
		this.rank = rank;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", subject=" + subject + ", section=" + section + ", rank=" + rank + "]";
	}

}
