package com.excelr.model;

public enum Role {
	ROLE_ADMIN,
	ROLE_GUEST,
	ROLE_LECTURAL,
	ROLE_USER;
	
	public String getAuthority() {
        return name();
    }
}
