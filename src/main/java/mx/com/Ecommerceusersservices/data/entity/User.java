package mx.com.Ecommerceusersservices.data.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import mx.com.Ecommerceusersservices.data.model.Address;

@Entity
@Data
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]{3,10}")
	private String name;
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]{3,20}")
	private String lastname;
	@NotEmpty
	@Pattern(regexp = "[0-9]{10}")
	private String phone;
	@NotEmpty
	private String birthdate;
	@NotEmpty
	private String gender;
	
	private String rol;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
	@OneToMany
	@JoinColumn(name = "id_user")
	@Transient
	private List<Address> addressList;
	
}
