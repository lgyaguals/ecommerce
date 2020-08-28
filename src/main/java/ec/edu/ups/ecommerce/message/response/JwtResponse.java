package ec.edu.ups.ecommerce.message.response;
import java.util.List;
public class JwtResponse {
	private String firstName;
	private String email;
	private List<String> roles;
    private String token;
    private String type = "Bearer";

    

    public JwtResponse(String token, String fristName, String email, List<String> roles ) {
    	this.token = token;
    	this.firstName = fristName;
		this.email = email;
		this.roles = roles;
		
	}

	public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}