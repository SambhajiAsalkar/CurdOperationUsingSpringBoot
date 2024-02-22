package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Rest_Student")
public class Students {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Integer StudentID;
	@Column(length=20)
private String student_name;
	@Column(length=20)
private Integer age;
private String addrs;
private Long mobileno;
}
