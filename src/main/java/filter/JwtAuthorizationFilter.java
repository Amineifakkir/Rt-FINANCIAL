package filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtfinancial.constant.HttpResponse;
import com.rtfinancial.utility.JWTTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;


import static com.rtfinancial.constant.SecurityConstant.OPTIONS_HTTP_METHOD;
import static com.rtfinancial.constant.SecurityConstant.TOKEN_PREFIX;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

	private final JWTTokenProvider jwtTokenProvider;
	private final ObjectMapper objectMapper;

	public JwtAuthorizationFilter(JWTTokenProvider jwtTokenProvider, ObjectMapper objectMapper) {
		this.jwtTokenProvider = jwtTokenProvider;
		this.objectMapper = objectMapper;
	}

	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase(OPTIONS_HTTP_METHOD)) {
            response.setStatus(HttpStatus.OK.value());
        } else {
            try {
                String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
                if (authorizationHeader == null || !authorizationHeader.startsWith(TOKEN_PREFIX)) {
                    filterChain.doFilter(request, response);
                    return;
                }
                String token = authorizationHeader.substring(TOKEN_PREFIX.length());
                String username = jwtTokenProvider.getSubject(token);

                if (jwtTokenProvider.isTokenValid(token)
                        && SecurityContextHolder.getContext().getAuthentication() == null) {
                    List<SimpleGrantedAuthority> authorities = jwtTokenProvider.getAuthorities(token);
                    Authentication authentication = jwtTokenProvider.getAuthentication(username, authorities, request);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } catch (TokenExpiredException ex) {
                sendErrorResponse(response, HttpStatus.UNAUTHORIZED, "Token has expired. Please log in again.");
                return;
            } catch (JWTVerificationException ex) {
                sendErrorResponse(response, HttpStatus.UNAUTHORIZED, "Invalid token.");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

	private void sendErrorResponse(HttpServletResponse response, HttpStatus status, String message) throws IOException {
		HttpResponse httpResponse = new HttpResponse(status.value(), status, status.getReasonPhrase().toUpperCase(),
				message);
		response.setStatus(status.value());
		response.setContentType("application/json");
		response.getWriter().write(objectMapper.writeValueAsString(httpResponse));
	}
}
