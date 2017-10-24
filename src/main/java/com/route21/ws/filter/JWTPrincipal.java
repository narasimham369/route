package com.route21.ws.filter;

import java.security.Principal;
import java.util.Arrays;

public class JWTPrincipal implements Principal {

	  private String name;
	  private String ptyname;
      private String email;
     
      private String[] roles;
      
      public JWTPrincipal(final String name,final String ptyname,final String[] role,final String email) {
          
          this.name      = name;
          this.email     = email;
          this.roles      = role;
          this.ptyname   = ptyname;
      }

    @Override
	public String getName() {
		
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPtyname() {
		return ptyname;
	}

	public void setPtyname(String ptyname) {
		this.ptyname = ptyname;
	}



	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("JWTPrincipal {")
               .append("name:").append(name).append(",")
               .append("ptyname:").append(ptyname).append(",")
               .append("roles:").append(Arrays.toString(roles))
               .append("email:").append(email).append(",")
               
               
               /*.append("firstName:").append(firstName).append(",")
               .append("lastName:").append(lastName).append(",")
               .append("organizations:").append(Arrays.toString(organizations)).append(",")
               .append("roles:").append(Arrays.toString(roles))*/
               .append("}");
        return builder.toString();
    }


}


