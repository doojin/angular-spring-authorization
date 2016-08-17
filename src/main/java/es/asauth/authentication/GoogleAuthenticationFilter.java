package es.asauth.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoogleAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private static final String AUTHENTICATION_FORM_ACTION = "/login";
    private static final String PARAMETER_TOKEN = "token";

    public GoogleAuthenticationFilter() {
        super(AUTHENTICATION_FORM_ACTION);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String token = httpServletRequest.getParameter(PARAMETER_TOKEN);
        return new UsernamePasswordAuthenticationToken("abc", token);
    }
}
