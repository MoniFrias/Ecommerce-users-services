package mx.com.Ecommerceusersservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mx.com.Ecommerceusersservices.data.entity.Response;
import mx.com.Ecommerceusersservices.data.entity.User;
import mx.com.Ecommerceusersservices.services.Services;

@RestController
@RequestMapping(path = "/user")
public class Controller {
	
	@Autowired
	Services services;
	
	@PostMapping(path = "/save")
	public ResponseEntity<Response> save(@Valid @RequestBody User user, BindingResult validResult){
		Response response = services.save(user, validResult);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/findAll")
	public ResponseEntity<Response> findAll(){
		Response response = services.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<Response> findById(@PathVariable Long id){
		Response response = services.findById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<Response> update(@Valid @RequestBody User user, @PathVariable Long id, BindingResult validResult){
		Response response = services.update(user, id, validResult);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/deleteById")
	public ResponseEntity<Response> deleteById(@RequestHeader(name = "id") Long id){
		Response response = services.deleteById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
