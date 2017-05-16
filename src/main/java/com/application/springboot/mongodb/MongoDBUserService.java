package com.application.springboot.mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MongoDBUserService implements UserService{

	@Autowired
	private  DBRepository dbRepository;
	
	
	@Override
	public UserDTO create(UserDTO userDTO) {
		User persistUser = new User();
		persistUser.setId(userDTO.getId());
		persistUser.setUsername(userDTO.getUsername());
		persistUser.setPassword(userDTO.getPassword());
		
		persistUser = dbRepository.save(persistUser);
		return convertToDTO(persistUser);
	}

	@Override
	public UserDTO delete(String id) {
		Optional<User> result = dbRepository.findOne(id);
		dbRepository.delete(result.get());
        return convertToDTO(result.get());
	}

	@Override
	public List<UserDTO> findAll() {
		List<User> userEntries = dbRepository.findAll();
		List<UserDTO> dto = new ArrayList<UserDTO>();
		for(User userEntry : userEntries)
		{
			dto.add(convertToDTO(userEntry));
		}
        return dto;
	}

	@Override
	public UserDTO findById(String id) {
		Optional<User> result = dbRepository.findOne(id);
		return convertToDTO(result.get());
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		User userUpdated = dbRepository.findOne(userDTO.getId()).get();
		userUpdated.update(userDTO.getUsername(), userDTO.getPassword());
		userUpdated = null;//dbRepository.save(userUpdated);
        return convertToDTO(userUpdated);
	}

	private UserDTO convertToDTO(User persistUser) {
		UserDTO dto = new UserDTO();
		dto.setId(persistUser.getId());
		dto.setUsername(persistUser.getUsername());
		dto.setPassword(persistUser.getPassword());
		return dto;
	}
}
