package mx.com.Ecommerceusersservices.data.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	@NotEmpty
	private String name;
	@NotEmpty
	private String lastname;
	@NotEmpty
	private String phone;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date birthdate;
	@NotEmpty
	private String gender;
	
	private String rol;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
}
