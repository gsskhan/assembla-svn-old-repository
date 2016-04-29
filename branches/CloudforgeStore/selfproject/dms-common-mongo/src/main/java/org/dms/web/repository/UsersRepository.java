package org.dms.web.repository;

import java.io.Serializable;
import java.util.List;

import org.dms.web.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, Serializable>{
	
	List<Users> findByUsername(String username);
	
	Users findOneByUsername(String username);
	
	List<Users> findByUsernameRegex(String username);
	
	Long deleteUsersById(String id);
	
	Users findOneById(String id);
	
	List<Users> findByUsernameNotAndRoleNot(String username,String role);
	
	List<Users> findByRoleNot(String role);
}
