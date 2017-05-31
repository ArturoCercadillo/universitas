package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Alumno;
import beans.Asignatura;
import beans.Usuario;
import peticiones.Peticiones;
import utils.Constantes;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Peticiones peticion = new Peticiones();
		Usuario user = peticion.httpLogin("http://"+Constantes.APIIP+"/apiRest/login", req.getParameter("usuario"), req.getParameter("password"));
		HttpSession session = req.getSession();
		session.setAttribute("user", user.getId());
			switch(user.getEstado()){
			case 1: Alumno alumno = peticion.httpAlumnoById("http://"+Constantes.APIIP+"/apiRest/alumno", user.getAlumno());
					System.out.println(alumno.getApellidos());
					req.setAttribute("id", alumno.getId());
					req.setAttribute("dni", alumno.getDni());
					req.setAttribute("nombre", alumno.getNombre());
					req.setAttribute("apellidos", alumno.getApellidos());
					req.setAttribute("mes", alumno.getMes());
					
					List<Asignatura> asignaturas = peticion.httpAsignaturasByAlumno("http://"+Constantes.APIIP+"/apiRest/alumno/asignaturas", user.getAlumno());
					
					req.setAttribute("asignaturas", asignaturas);
					
					for(Asignatura asignatura : asignaturas){
						asignatura.setProfesor(peticion.httpProfesorById("http://"+Constantes.APIIP+"/apiRest/profesores", asignatura.getIdProfesor()).getNombre());
					}
					
			req.getServletContext()
			.getRequestDispatcher("/Alumno.jsp")
			.forward(req, resp);
			break;
			case 2: req.getServletContext()
			.getRequestDispatcher("/Notas.jsp")
			.forward(req, resp);
			break;
			case 99: req.getServletContext()
			.getRequestDispatcher("/Alumno.jsp")
			.forward(req, resp);
			break;
			default: break;
			}
	}
	
}
