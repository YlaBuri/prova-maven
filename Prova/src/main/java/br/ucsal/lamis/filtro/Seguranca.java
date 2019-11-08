package br.ucsal.lamis.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Seguranca
 */
@WebFilter("/*")
public class Seguranca implements Filter {


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		Object object = httpServletRequest.getSession().getAttribute("usuario");
		//Usuario esta logado existe um objeto usuario na sessao
		if (object != null ) {
			chain.doFilter(request, response);
			
		//Sem usuario na sessao
		}else {
		
			//verifica se são paginas publicas index.jsp e o servlet de Login
			if( httpServletRequest.getRequestURI().endsWith("index.jsp") ||
					httpServletRequest.getRequestURI().endsWith("Login")) {
				chain.doFilter(request, response);

			}else {
				// Paginas provadas redireciona para o index
				httpServletResponse.sendRedirect("./index.jsp");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
