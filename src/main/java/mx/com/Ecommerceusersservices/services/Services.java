package mx.com.Ecommerceusersservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;
import mx.com.Ecommerceusersservices.data.entity.Response;
import mx.com.Ecommerceusersservices.data.entity.User;
import mx.com.Ecommerceusersservices.data.entity.ValidationException;
import mx.com.Ecommerceusersservices.data.repository.RepositoryUser;

@Service
public class Services {

	@Autowired
	RepositoryUser repositoryUser;
	Response response = new Response();

	public Response save(User user, BindingResult validResult) {
		User userFound = repositoryUser.findByEmail(user.getEmail());
		if (!validResult.hasErrors() && userFound == null) {
			response.setData(repositoryUser.save(user));
			return response;
		} else {
			throw new ValidationException("Already exits a user with that email");
		}
	}

	public Response findAll() {
		List<User> userList = repositoryUser.findAll();
		if (!userList.isEmpty()) {
			response.setData(userList);
			return response;
		} else {
			throw new ValidationException("No exits any user");
		}
	}

	public Response findById(Long id) {
		if (id > 0) {
			Optional<User> userFound = repositoryUser.findById(id);
			if (userFound.isPresent()) {
				response.setData(userFound);
				return response;
			} else {
				throw new ValidationException("There is not a user with that ID");
			}
		} else {
			throw new ValidationException("ID can not be zero or null");
		}
	}

	public Response update(@Valid User user, Long id, BindingResult validResult) {
		if (id > 0) {
			Optional<User> userFound = repositoryUser.findById(id);
			if (userFound.isPresent() && !validResult.hasErrors()) {
				response.setData(repositoryUser.save(setData(user, userFound.get())));
				return response;
			} else {
				throw new ValidationException("Some values are wrong or already exits a patient with that info");
			}
		} else {
			throw new ValidationException("ID can not be zero or null");
		}
	}

	public Response deleteById(Long id) {
		if (id > 0) {
			Optional<User> userFound = repositoryUser.findById(id);
			if (userFound.isPresent()) {
				repositoryUser.deleteById(id);
				return response;
			} else {
				throw new ValidationException("There arent a patient with tha id");
			}
		} else {
			throw new ValidationException("Id cant be null or zero");
		}
	}

	private User setData(User user, User userFound) {
		userFound.setName(user.getName());
		userFound.setLastname(user.getLastname());
		userFound.setPhone(user.getPhone());
		userFound.setBirthdate(user.getBirthdate());
		userFound.setGender(user.getGender());
		userFound.setRol(user.getRol());
		userFound.setEmail(user.getEmail());
		userFound.setPassword(user.getPassword());
		return userFound;
	}
}
