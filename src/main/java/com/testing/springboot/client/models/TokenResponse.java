package com.testing.springboot.client.models;

public class TokenResponse {
    private String access_token;
    private String refresh_token;
    private String scope;
    private String id_token;
    private String token_type;
    private String expires_in;

    public String getAccess_token() {
        return access_token;
    }
}
