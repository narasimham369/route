package com.route21.ws.helper;

import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.lang.JoseException;
import org.springframework.stereotype.Component;

@Component
public class RsaKeyProducer {
	
	private RsaKeyProducer() {
    }
    
    private static RsaJsonWebKey theOne;
    
    /**
     * 
     * not an ideal implementation since does not implement double-lock synchronization check
     */
    public static RsaJsonWebKey produce(){
        if(theOne == null){
            try {
                theOne = RsaJwkGenerator.generateJwk(2048);
            } catch (JoseException ex) {
                            }
        }
         
        System.out.println("RSA Key setup... "+ theOne.hashCode());
        return theOne;
    }

}
