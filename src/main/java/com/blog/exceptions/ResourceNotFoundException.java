package com.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	String name;
	String field;
	long  val;
	public ResourceNotFoundException(String name, String field, long val) {
		super(String.format("%s not found with %s : %s", name,field,val));
		this.name = name;
		this.field = field;
		this.val = val;
	}
	
	
}
