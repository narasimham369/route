package com.route21.ws.filter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nimbusds.jwt.JWTClaimsSet;
import com.route21.ws.annotation.JWTSecured;
import com.route21.ws.exception.DataNotFoundException;
import com.route21.ws.exception.NotAuthorizedException;
import com.route21.ws.exception.OperationProhibitedException;
import com.route21.ws.helper.RsaKeyProducer;
import com.route21.ws.types.Role;

@JWTSecured
public class JWTRequestFilter implements ContainerRequestFilter {
	
	 private static final Logger log = LoggerFactory.getLogger(JWTRequestFilter.class);
	
	
	 private Pattern tokenPattern  = Pattern.compile("^Bearer$", Pattern.CASE_INSENSITIVE);
	 
	 @Context
	 private ResourceInfo resourceInfo;
    
 
	 @Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		 String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		 
	        if (authorizationHeader != null) {
	            String token = parseBearerToken(authorizationHeader);
	            if (token != null) {
	                JwtClaims claims = null;
					try {
						claims = validate(token);
						
						
					} catch (InvalidJwtException e) {
						
						e.printStackTrace();
					}
	                JWTPrincipal principal  = buildPrincipal(claims);
	                if (principal != null) {
	                    Class<?> resourceClass = resourceInfo.getResourceClass();
	                    List<Role> classRoles = extractRoles(resourceClass);
	                    
	                    Method resourceMethod = resourceInfo.getResourceMethod();
	                    List<Role> methodRoles = extractRoles(resourceMethod);

	                    try {

	                        // Check if the user is allowed to execute the method
	                        // The method annotations override the class annotations
	                        if (methodRoles.isEmpty()) {
	                            checkPermissions(classRoles,principal);
	                        } else {
	                            checkPermissions(methodRoles,principal);
	                        }

	                    } catch (Exception e) {
	                 
	                    	 throw new OperationProhibitedException("You are not allowed to proceed.");
	                    }
	                    
	                    
	                    // Build and inject JavaEE SecurityContext for @RoleAllowed, isUserInRole(), getUserPrincipal() to work
	                    JWTSecurityContext ctx = new JWTSecurityContext(
	                                                    principal,
	                                                    requestContext.getSecurityContext().isSecure());
	                    requestContext.setSecurityContext(ctx);
	                } else {
	                	
	                	throw new NotAuthorizedException("Unauthorized: Unable to parse Bearer token");
	                   
	                }
	            } else {
	                throw new NotAuthorizedException(
	                            "Unauthorized: Unable to parse Bearer token");
	            }
	        } else {
	        	
	        	throw new NotAuthorizedException("Unauthorized: No Authorization header was found");
	           
	        }

		
	}
	
	private PublicKey loadPublicKey(String keystoreFile, String password, String alias) {
        PublicKey publicKey = null;
        log.debug("Loading public key: {} from keystore: {}", alias, keystoreFile);
        try {
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());

            File file = new File(keystoreFile);
            InputStream is = null;
            if (file.exists()) {
                is = new BufferedInputStream(new FileInputStream(file));
            } else {
                is = getClass().getResourceAsStream(keystoreFile);
            }

            if (is != null) {
              keystore.load(is, password.toCharArray());
              Certificate cert = keystore.getCertificate(alias);
              if (cert != null) {
                  publicKey = cert.getPublicKey();
              } else {
                  log.error("Invalid key alias provided, key not found");
              }
            } else {
                log.error("Unable to load keystore file: {}", keystoreFile);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return publicKey;
    }
	
	 private String parseBearerToken(final String bearerToken) {
	        String tokenValue = null;
	        if (bearerToken  != null) {
	            String[] parts = bearerToken.split(" ");
	            if (parts.length == 2) {
	                String scheme       = parts[0];
	                String credentials  = parts[1];
	                if (tokenPattern.matcher(scheme).matches()) {
	                    tokenValue = credentials;
	                }
	            }
	        }
	        return tokenValue;
	    }
	 
	 private JWTPrincipal buildPrincipal(final JwtClaims claims) {
	        JWTPrincipal principal = null;

	        try {
	            if (claims != null) {
	            	
	            	String subject  = claims.getSubject();
	            	String name     = (String)claims.getClaimValue("name");
	                String role		= (String)claims.getClaimValue("role");
	                String email  	= (String)claims.getClaimValue("email");
	                String[] roles= { role };
	               
	                //  Extract custom attributes, e.g. roles, organization affiliation etc. and put into principal.

	                principal = new JWTPrincipal(subject, name, roles, email);
	            }
	        } catch (Exception e) {
	            log.error(e.getMessage(), e);
	        }
	        return principal;
	    }
	 
	 private JWTClaimsSet validateToken(final String token) {
	        JWTClaimsSet claims = null;
	        

	        
	        return claims;
	    }
	 
	 
	    private JwtClaims validate(String jwt) throws InvalidJwtException {
	        String subject = null;
	        JwtClaims jwtClaims =null;
	        
	        RsaJsonWebKey rsaJsonWebKey = RsaKeyProducer.produce();

	        System.out.println("RSA hash code... " + rsaJsonWebKey.hashCode());

	        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
	                .setRequireSubject() // the JWT must have a subject claim
	                .setVerificationKey(rsaJsonWebKey.getKey()) // verify the signature with the public key
	                .build(); // create the JwtConsumer instance

	        try {
	            //  Validate the JWT and process it to the Claims
	             jwtClaims = jwtConsumer.processToClaims(jwt);	            
	            
	            
	             
	             try {
	            	 NumericDate now = NumericDate.now();
	            	 
	            	 if(jwtClaims.getExpirationTime().isBefore(now))
	            	 {
	            	
	            		 throw new NotAuthorizedException(
                                 "Unauthorized: too early, token not valid yet");
	            	 }
	            	 else if(jwtClaims.getNotBefore().isAfter(now))
	            	 {
	            
	            		 throw new NotAuthorizedException(
	            				 "Unauthorized: too early, token not valid yet");
	            	 }
					
	            	 System.out.println("now::::"+now);
				} catch (MalformedClaimException e) {
				
					e.printStackTrace();
				}
	            
	            
	            System.out.println("JWT validation succeeded! " + jwtClaims);
	        } catch (InvalidJwtException e) {
	            e.printStackTrace(); //on purpose
	            throw e;
	        }

	        return jwtClaims;
	    }
	    
	    private List<Role> extractRoles(AnnotatedElement annotatedElement) {
	        if (annotatedElement == null) {
	            return new ArrayList<Role>();
	        } else {
	            JWTSecured secured = annotatedElement.getAnnotation(JWTSecured.class);
	            if (secured == null) {
	                return new ArrayList<Role>();
	            } else {
	                Role[] allowedRoles = secured.value();
	                return Arrays.asList(allowedRoles);
	            }
	        }
	    }
	    
	    private void checkPermissions(List<Role> allowedRoles, JWTPrincipal principal) throws Exception {
	        Role jwtrole = Enum.valueOf(Role.class, principal.getRoles()[0]);
	        
            if(!allowedRoles.contains(jwtrole))
            {
               throw new NotAuthorizedException(
                       "Unauthorized: Unable to parse Bearer token");
               
            }
	    }


}
