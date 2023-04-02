package com.Zeal.Exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class ResourceNotFound extends RuntimeException {
	
	private String resource;
	private  String fieldName;
	private int Value;
	public ResourceNotFound(String resource, String fieldName, int value) {
		super(String.format("%s Is Not Found With This %s : %s",resource,fieldName,value));
		this.resource = resource;
		this.fieldName = fieldName;
		Value = value;
	}
	
	
	
	
	

}
