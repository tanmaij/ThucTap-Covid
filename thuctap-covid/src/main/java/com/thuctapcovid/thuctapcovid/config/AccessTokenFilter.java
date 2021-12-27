package com.thuctapcovid.thuctapcovid.config;

import com.thuctapcovid.thuctapcovid.exception.AuthorizationException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessTokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String path = httpRequest.getRequestURI();
            if(path.equals("/api/auth/login")) {
                chain.doFilter(request, response);
                return;
            }
            String accessToken = httpRequest.getHeader("Authorization");

            String username=getUsernameFromAccessToken(accessToken);

            chain.doFilter(request, response);
        }
        catch(Exception e)
            {
                System.out.println(e);
                response=(HttpServletResponse)response;
                ((HttpServletResponse) response).sendError(HttpStatus.UNAUTHORIZED.value(), "Vui lòng đăng nhập");
            }
    }
    private String setcretKey;
    @Value("${bezkoder.app.jwtSecret}")
    public void setSetcretKey(String setcretkey) {
        setcretKey = setcretkey;
    }

    public String getUsernameFromAccessToken(String accessToken) {
        try {
            return Jwts.parser().setSigningKey("dwpdwaewfefoismlmlmweflmpfo3r939fj0fjwoifeoimdomdo3dmwofjoi3jro3jd9fef3goifnqnr3lrmllkvnknoaiwenf").parseClaimsJws(accessToken).getBody().getSubject();
        } catch (Exception e) {
            System.out.println(e);
            throw new AuthorizationException("Ban chưa đăng nhập");
        }
    }

}
