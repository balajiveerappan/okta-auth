package com.cglean.wb.service;

import com.cglean.wb.service.util.Token;
import com.cglean.wb.service.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sanrawat on 2/13/2017.
 */
@Service
public class AccessTokenService {

    @Value("${app.token.url}")
    private String url;

    @Value("${app.clientid}")
    private String clientid;

    @Value("${app.clientsecret}")
    private String clientsecret;

    private RestTemplate restTemplate;

    @Autowired
    public AccessTokenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Token getAccessToken(User user) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");

        // Create the request body as a MultiValueMap
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("grant_type", "password");
        body.add("client_id", clientid);
        body.add("client_secret", clientsecret);
        body.add("redirect_uri", "http://www.hascode.com");
        body.add("username", user.getUsername());
        body.add("password", user.getPassword());
        body.add("scope", "openid");

        // Note the body object as first parameter!
        HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);

        ResponseEntity<Token> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Token.class);
        Token token = response.getBody();

        return token;
    }

}
