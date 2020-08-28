package ec.edu.ups.ecommerce.message.request;

import javax.validation.constraints.*;

public class SignUpForm {
   
    @NotBlank
    @Size(min = 6, max = 50)
    private String username;

    @NotBlank
    @Size(max = 120)
    @Email
    private String email;
    
    @NotBlank
    @Size(max=60)
    private String firstName;
    
    @NotBlank
    @Size(max=1)
    private String documentType;
    
    @NotBlank
    @Size(max=10)
    private String document;
    
    
    @NotBlank
    @Size(max=60)
    private String lastName;
    
    @NotBlank
    private boolean provider;
    
   
    
    @NotBlank
    @Size(min = 8, max = 16)
    private String password;

   

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getProvider() {
		return provider;
	}

	public void setProvider(boolean provider) {
		this.provider = provider;
	}

	

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}