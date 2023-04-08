package org.acme.securite;

import io.smallrye.jwt.build.Jwt;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class AuthentificationJwtService {

    public String generateJwt(){

        Set<String> roles = new HashSet<>(Arrays.asList("admin","employeur", "agence"));

        long duration =System.currentTimeMillis() +3600;

       return Jwt.issuer("AuthentificationJwtService")
                .subject("AuthentificationJwtService")
                .groups(roles)
                .expiresAt(duration)
                .sign();

    }
    
}
