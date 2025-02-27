package com.co.fashion.application.dto.request;

import com.co.fashion.domain.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequest {
	private Long id;

	private String name;

	private String lastName;
	private String password;

	private String phoneNumber;
	private String email;
	private String username;
	private List<Role> roles;

}
