package br.ucsal.lamis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.DAO.BlocoDAO;
import br.ucsal.lamis.DAO.LaboratorioDAO;
import br.ucsal.lamis.model.Laboratorio;


/**
 * Servlet implementation class LaboratorioForm
 */
@WebServlet("/LaboratorioForm")
public class LaboratorioFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		Laboratorio laboratorio = null;
		if(sid !=null ) {
			laboratorio = LaboratorioDAO.obterLaboratorio(Integer.parseInt(sid));
		}
		request.setAttribute("blocos",BlocoDAO.getBlocos());
		request.getRequestDispatcher("laboratorioForm.jsp").forward(request, response);
		
	}


}
