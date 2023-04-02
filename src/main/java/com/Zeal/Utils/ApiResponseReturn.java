package com.Zeal.Utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseReturn {

	private String status;
	private boolean success;

	public ApiResponseReturn(String status, boolean success) {
		super();
		this.status = status;
		this.success = success;
	}

	
}
