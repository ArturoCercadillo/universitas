package servlets;

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
import javax.servlet.http.HttpSession;

@WebFilter({"/","/Alumno.jsp"})
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(true);
        String loginURI = request.getContextPath() + "/login.html";
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        //boolean loginRequest = request.getRequestURI().equals(loginURI);

        if (loggedIn) {
        	req.getServletContext()
			.getRequestDispatcher("/Alumno.jsp")
			.forward(req, res);
        } else {
        	req.getServletContext()
			.getRequestDispatcher("/login.html")
			.forward(req, res);
        }
    }

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

    // ...
}