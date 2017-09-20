package com.segurosthona.scg.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {
    /**
     * Returns true if any role starts with some prefix.
     */
    public boolean hasRoleStartsWith(UserDetails user, String rolePrefix) {
        for (GrantedAuthority auth : user.getAuthorities()) {
            if (auth.getAuthority().startsWith(rolePrefix)){            
            	return true;
            }
        }
        return false;
    }
    
	public static String getCurrentUser(){
		String nombreAcceso = ((UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getUsername();
		return nombreAcceso;		
	}
	
    public static boolean hasCurrentUserRole(String role) {
    	UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        for (GrantedAuthority auth : user.getAuthorities()) {
            if (auth.getAuthority().equalsIgnoreCase(role)){            
            	return true;
            }
        }
        return false;
    }
    
  
  
}
