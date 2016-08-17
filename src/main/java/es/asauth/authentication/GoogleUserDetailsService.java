package es.asauth.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class GoogleUserDetailsService implements AuthenticationUserDetailsService<UsernamePasswordAuthenticationToken> {

    @Override
    public UserDetails loadUserDetails(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws UsernameNotFoundException {
        return null;
    }
}
