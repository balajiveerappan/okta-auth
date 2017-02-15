package com.cglean.wb.config;

//import org.apache.http.client.HttpClient;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;


@Configuration
public class OAuth2ServerConfiguration {

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/public/**").permitAll()
                    .antMatchers("/**").authenticated()
                    .and()
                    .csrf().disable();
        }

//        @Override
//        public void configure(ResourceServerSecurityConfigurer config) {
//            config.tokenServices(tokenServices());
//        }
//
//        @Bean
//        @Primary
//        public DefaultTokenServices tokenServices() {
//            DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//            defaultTokenServices.setTokenStore(tokenStore());
//            return defaultTokenServices;
//        }
//
//        @Bean
//        public TokenStore tokenStore() {
//            return new JwtTokenStore(accessTokenConverter());
//        }
//
//        @Bean
//        public JwtAccessTokenConverter accessTokenConverter() {
//            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//            converter.setSigningKey("JVgZWviLl38kJlbYjOvTGV0uWVACInRHpn-i6xlfZoyI_KwGz8kSoVe8JmfzHhdHFUiCv2hiH9nNMNzQ6MemkqzVb2rnSFiOJ-vhlVlWlCozDyR458SjQBVIH3kujwnbdC0dwcLyVoOLqNj-JfqFS36Z7aUKFGbVEsr_AI5RRsn6nsaQ-sFo3-b6uAVoJMIa47q3jG7MgltNfDgmaaonwUPauXZztKzB1ZwJ3yxaXwDfchS-98kfXgzbIg2dU4OBj85UY0RP3BVBkxpuvW0GaUZvuBxfyH6kMhlhWabIql0rzxGjy0eT-z3EUHNuhizGN9HdqrGWzs1YVEcw");
//
//            return converter;
//        }

    }

//    @Value("classpath:oktaKeystore.jks")
//    private Resource cert;

    @Bean
    RestTemplate getRestTemplate(){
//        SSLConnectionSocketFactory socketFactory = null;
//        File keyStoreFile = null;
//        try {
//            keyStoreFile = cert.getFile();
//
//            System.out.println("**********************************************");
//            System.out.println(keyStoreFile.getAbsolutePath());
//            System.out.println("**********************************************");
//
//            socketFactory = new SSLConnectionSocketFactory(new SSLContextBuilder().loadTrustMaterial(keyStoreFile, "changeit".toCharArray(), new TrustSelfSignedStrategy()).build());
//        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException | IOException | CertificateException e) {
//            e.printStackTrace();
//        }
//        HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
//        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//
//        return new RestTemplate(httpComponentsClientHttpRequestFactory);
        return new RestTemplate();
    }

}