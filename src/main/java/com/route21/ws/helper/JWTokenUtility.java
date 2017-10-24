package com.route21.ws.helper;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.apache.commons.codec.binary.Base64;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.json.internal.json_simple.parser.JSONParser;
import org.jose4j.json.internal.json_simple.parser.ParseException;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;
import org.springframework.stereotype.Component;

@Component
public class JWTokenUtility {
	
	public static String buildJWT(String subject,String partyname,String roletype,String email, long ptyId) {
        RsaJsonWebKey rsaJsonWebKey = RsaKeyProducer.produce();
        System.out.println("RSA hash code... " + rsaJsonWebKey.hashCode());

        JwtClaims claims = new JwtClaims();
        claims.setSubject(subject); // the subject/principal is whom the token is about
        claims.setClaim("name", partyname);       
        claims.setClaim("email", email);
        claims.setClaim("ptyId", ptyId);
        claims.setClaim("role", roletype);
        claims.setExpirationTimeMinutesInTheFuture(15);
        claims.setIssuedAtToNow();
        claims.setNotBeforeMinutesInThePast(1);

        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setKey(rsaJsonWebKey.getPrivateKey());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

        String jwt = null;
        try {
            jwt = jws.getCompactSerialization();
        } catch (JoseException ex) {
           
        }

        System.out.println("Claim:\n" + claims);
        System.out.println("JWS:\n" + jws);
        System.out.println("JWT:\n" + jwt);

        return jwt;
    }

	public static long Jwtdecoder(@Context HttpServletRequest req) throws ParseException{
		
		 String jwttocken = req.getHeader("Authorization");
		   System.out.println(jwttocken);
		 
		   String tockensplit[] =  jwttocken.split("\\.");
		   System.out.println("subj::"+ tockensplit[1]);
		   String decodeAuthToken = new String(Base64.decodeBase64(tockensplit[1]));
		   	JSONParser parser = new JSONParser();
		   	JSONObject json = (JSONObject) parser.parse(decodeAuthToken);
		   	Long PtyId =  (Long) json.get("ptyId");
			System.out.println("PtyId"+PtyId);
			
		return PtyId;
	}
}
