package ec.edu.ups.ecommerce.message.request;

import javax.validation.constraints.NotBlank;

public class ModelRequest {
	@NotBlank
	String name;
	@NotBlank
	Long brandId;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	
	
}
