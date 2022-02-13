package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Login;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private LoginRepository loginRepository; 
	

//	private UserServiceImpl() throws IOException {
//		
//	}
	// getting repository object through spring
//    public UserServiceImpl() throws IOException {
//		
//	}
//	

//	private static UserService service;
//	public static UserService getInstance() throws IOException{
//		if(service==null)
//			service = new UserServiceImpl();
//		return service;
//	}
	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor=AlreadyExistsException.class)
	public User addUser(User register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		//make exception for the next line
		if(repository.existsByEmailAndContactNumber(register.getEmail(), register.getContactNumber()) == true) {
			throw new AlreadyExistsException("already exists");
		}
		User register2 = repository.save(register);
		if (register2 != null) {
			Login login = new Login(register.getEmail(), register.getPassword(),register2);
			if(loginRepository.existsByUserName(register.getEmail())) {
				throw new AlreadyExistsException("already exists");
			}
			String result = service.addCredentials(login);
			if(result == "success") {
					return register2;
			}
			else
			{
				return null;
			}
		}	
		else {
			return null;
		}
				
	}

	@Override
	public String updateUser(Long id, User register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
		//we dont write here coz update is automatically taken care of
	}

	@Override
	public User getUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
	   Optional<User>optional=repository.findById(id);
	   if(optional.isEmpty())
	   {
		   throw new IdNotFoundException("id not exist");
	   }
	   else
	   {
		return optional.get() ;
	   }
	}

	@Override
	public Optional<List<User>> getAllUsers()
			 {
		// TODO Auto-generated method stub
		List<User> list = repository.findAll();
		User[] array = new User[list.size()];
		return Optional.ofNullable(repository.findAll());
		
		
	}

	@Override
	public String deleteUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		//cross check with findbyid
		//use optional here coz findbyid return optional type

			User optional;
			try {
				optional = this.getUserById(id);
				if(optional==null) {
					throw new IdNotFoundException("record not found");
				}
				else {
					repository.deleteById(id);
					return "register record deleted";
				}
			} catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IdNotFoundException(e.getMessage());
			}
		
	}

	@Override
	public Optional<List<User>> getAllUserDetails()
	{
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

}