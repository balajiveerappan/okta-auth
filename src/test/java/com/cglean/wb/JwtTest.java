//package com.cglean.wb;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.exceptions.JWTDecodeException;
//import com.auth0.jwt.interfaces.Claim;
//import org.junit.Test;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
//
//import java.util.Map;
//
///**
// * Created by sanrawat on 2/15/2017.
// */
//
//
//public class JwtTest {
//
//    @Test
//    public void verifyJWT(){
//
//        String token = "eyJhbGciOiJSUzI1NiIsImtpZCI6IlRqMlpqU3pNRWZyamFoSGdCYnJFOGhiNG9pVzQ4Skw2bWQ0RlhLVEhGMU0ifQ.eyJ2ZXIiOjEsImp0aSI6IkFULlBaWndMeGJFSmI4dS1RS3lZYlBESHNSXzNOQmYtTGdOSWpDcmk0WVp6bjgiLCJpc3MiOiJodHRwczovL2Rldi0xODI2Mjgub2t0YXByZXZpZXcuY29tL29hdXRoMi9hdXM5andnb2NiYWpEb3lWcTBoNyIsImF1ZCI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImlhdCI6MTQ4NzE0ODQzMywiZXhwIjoxNDg3MTUyMDMzLCJjaWQiOiJSeTQyM1JXcGh3Q3ZWa3pqekxDbSIsInVpZCI6IjAwdTloazl2ejdqWHY5VE10MGg3Iiwic2NwIjpbIm9wZW5pZCJdLCJzdWIiOiJzYW5qYXkucmF3YXRAY2FwZ2VtaW5pLmNvbSJ9.ESmLDA7eGLh9Ty6XFYlHQLPWQnY94EUFmGOsxkVC-r07Wfs99ADbumsvWLbYQrGvcl8KQt7E0tr6QG0KAWiQlHD5vHmJiLAVBuTzsqPvIDqIee3EpNHHxVEHBHsqquIr5VGaq0OUoFE72EnPJyJBZwfoMXsk4oIU3C9LTWr-TAt4twbE0ezBe89NGkS3hoHuCvxQ7G0D1nisxmuhqWnMZKGXmA2jiebhl6YmQOpXsb9mrJJLBxImSaBVVcYqM8xXWRLjLeX54tJ8SoPpARFIxEhYtEponGDRjV3BrySx7QCNtrcCEv9VZZ_3liSJ3TqyC_eeMwbup4tgFieHZ0-T3g";
//        try {
//            JWT jwt = JWT.decode(token);
//            System.out.println(jwt.getAlgorithm());
//            jwt.getAudience().forEach(aud -> System.out.println(aud));
//            System.out.println(jwt.getToken());
//            Map<String, Claim> claims = jwt.getClaims();
//            claims.forEach((s,c)-> {
//                System.out.println(s);
//                //System.out.println(c.toString());
//            });
//
//        } catch (JWTDecodeException exception){
//            exception.printStackTrace();
//        }
//
//    }
//
//}
