package com.route21.ws.filter;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JWTSecurityContext implements SecurityContext{
	
	private static final Logger log = LoggerFactory.getLogger(JWTSecurityContext.class);
	
    private JWTPrincipal principal;
    private boolean      isSecure;
    private Set<String>  roles = new HashSet<String>();
	
	public JWTSecurityContext(final JWTPrincipal principal, final boolean isSecure) {
        this.principal  = principal;
        this.isSecure   = isSecure;
        String[] names  = principal.getRoles();
        for (int iIndex = 0; names != null && iIndex < names.length; ++iIndex) {
            roles.add(names[iIndex]);
        }
     
        log.trace("JWTSecurityContext() - principal: {}, roles: {}, isSecure: {}", principal, roles, isSecure);
    }

	@Override
	public Principal getUserPrincipal() {
	
		return principal;
	}

	@Override
	public boolean isUserInRole(String role) {
	    System.out.println(roles);
		return roles.contains(role);
	}

	@Override
	public boolean isSecure() {
		
		return isSecure;
	}

	@Override
	public String getAuthenticationScheme() {
		
		return "JWT";
	}
	
	 @Override
     public String toString() {
         StringBuilder builder = new StringBuilder();
         builder.append("JWTSecurityContext {")
                .append("principal:").append(principal).append(",")
                .append("roles:").append(roles).append(",")
                .append("isSecure:").append(isSecure)
                .append("}");
         return builder.toString();
     }

}
