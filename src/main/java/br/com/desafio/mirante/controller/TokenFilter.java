/*
 * Programadora: Rebeca Divina Paula
 */
package br.com.desafio.mirante.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class TokenFilter extends GenericFilterBean {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException{
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String header = req.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer ")){
			throw new ServletException("Token inexistente ou inválido");
		}
		
		String token = header.substring(7);
		try{
			Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
			
		}catch (SignatureException e) {
			throw new ServletException("Token Inválido");
		}
		chain.doFilter(request, response);
	}
}
