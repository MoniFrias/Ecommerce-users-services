package mx.com.Ecommerceusersservices.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.Ecommerceusersservices.data.entity.User;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
