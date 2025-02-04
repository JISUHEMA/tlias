package com.eden;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@SpringBootTest
class EmpjspApplicationTests {

	@Test
	public void testGenJwt() {
	    SecretKey signKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	    int expire = 3600000;

	    Map<String, Object> claims = new HashMap<>();
	    claims.put("id", 1);
	    claims.put("name", "tom");

	    String jwt = Jwts.builder()
	            .addClaims(claims)
	            .signWith(signKey, SignatureAlgorithm.HS256)
	            .setExpiration(new Date(System.currentTimeMillis() + expire))
	            .compact();
	    
	    System.out.println(jwt);
	    
	    Map<String, Object> claims1 = new HashMap<>();
	    claims1=Jwts.parser().setSigningKey(signKey).parseClaimsJws(jwt).getBody();

	    System.out.println(claims1.toString());
	}

}
