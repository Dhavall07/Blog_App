package com.blog.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Comment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String content;
	@ManyToOne
	private Post post;

	
}
