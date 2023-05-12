package mx.com.Ecommerceusersservices.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {

	private boolean result = true;
	private String message = "success";
	private Object data;

}
