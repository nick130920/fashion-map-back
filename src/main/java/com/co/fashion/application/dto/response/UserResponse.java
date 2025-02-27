package com.co.fashion.application.dto.response;

import com.co.fashion.domain.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {
	private Long id;

	private String name;

	private String lastName;

	private String phoneNumber;
	private String email;
	private String username;
	private List<Role> roles;
	
}
