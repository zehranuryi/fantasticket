package com.codecrew.fantasticket.service.impl;

import com.codecrew.fantasticket.dao.UserRepository;
import com.codecrew.fantasticket.dto.UserRequestDto;
import com.codecrew.fantasticket.dto.UserResponseDto;
import com.codecrew.fantasticket.entity.User;
import com.codecrew.fantasticket.enums.Role;
import com.codecrew.fantasticket.service.UserService;
import com.codecrew.fantasticket.transformer.DtoFromEntityTransformer;
import com.codecrew.fantasticket.transformer.EntityFromDtoTransformer;
import com.codecrew.fantasticket.util.security.CustomUserDetails;
import com.codecrew.fantasticket.util.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DtoFromEntityTransformer dtoFromEntityTransformer;
	
	@Autowired
	private EntityFromDtoTransformer entityFromDtoTransformer;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<UserResponseDto> getAll(){
		return userRepository.findAll().stream().map(user -> {
			return dtoFromEntityTransformer.userDtoFromEntity(user);
		}).collect(Collectors.toList());
	}

	@Override
	public User getOneById(Integer id){
		return userRepository.findById(id).orElseThrow(); // TODO THROW RESOURCE
	}

	@Override
	public UserResponseDto getOneByIdDto(Integer id){
		return dtoFromEntityTransformer.userDtoFromEntity(getOneById(id)); // TODO THROW RESOURCE
	}
	
	@Override
	public User findByUsername(String username){
		return userRepository.findByUsername(username).orElseThrow();// TODO THROW RESOURCE NOT FOUND
	}
	
	@Override
	public UserResponseDto findByUsernameDTO(String username){
		return dtoFromEntityTransformer.userDtoFromEntity(findByUsername(username));// TODO THROW RESOURCE NOT FOUND
	}
	
	@Override
	public UserResponseDto findByEmailDto(String email){
		return dtoFromEntityTransformer.userDtoFromEntity(findByEmail(email));
	}
	
	@Override
	public User findByEmail(String email){
		return userRepository.findByEmail(email).orElseThrow(); // TODO THROW EXCEPTION
	}
	
	@Override
	public UserResponseDto signInUserReturnDto(UserRequestDto userRequestDto){
		var user = entityFromDtoTransformer.userFromDto(userRequestDto);
		user.setActive(true);
		user.setRole(Role.CUSTOMER);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		var savedUser = userRepository.save(user);
		var token = jwtProvider.generateToken(new CustomUserDetails(savedUser));
		savedUser.setToken(token);
		
		return dtoFromEntityTransformer.userDtoFromEntity(savedUser);
	}
	
	@Override
	@Transient
	public UserResponseDto changeRole(Integer userId, Role role){
		var user = userRepository.findById(userId).orElseThrow();// TODO THROW EXCEPTION
		user.setRole(role);
		return dtoFromEntityTransformer.userDtoFromEntity(userRepository.save(user));
	}
}