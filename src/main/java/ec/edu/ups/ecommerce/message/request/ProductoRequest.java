package ec.edu.ups.ecommerce.message.request;

import javax.validation.constraints.NotBlank;

public class ProductoRequest {
	
	@NotBlank
	private Long model;
	
	@NotBlank
	private Long provider;
	
	@NotBlank
	private float price;
	
	@NotBlank
	private String description;
	
	private String urlImage;
	
	public Long getModel() {
		return model;
	}
	public void setModel(Long model) {
		this.model = model;
	}
	public Long getProvider() {
		return provider;
	}
	public void setProvider(Long provider) {
		this.provider = provider;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	
}
