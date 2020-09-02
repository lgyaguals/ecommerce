package ec.edu.ups.ecommerce.message.request;

import javax.validation.constraints.NotBlank;

public class MarcaRequest {
	@NotBlank
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	
}
