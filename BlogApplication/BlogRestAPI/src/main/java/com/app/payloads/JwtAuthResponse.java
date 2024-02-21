package com.app.payloads;

public class JwtAuthResponse {
	
	private String token;
    private String email;

    
    public JwtAuthResponse(String token, String email) {
		super();
		this.token = token;
		this.email = email;
	}

	public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
