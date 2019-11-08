package br.ucsal.lamis.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.DAO.LaboratorioDAO;



/**
 * Servlet implementation class ReservaForm
 */
@WebServlet("/ReservaForm")
public class ReservaForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReservaForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lamis", LaboratorioDAO.listarLaboratorios());
		
		request.getRequestDispatcher("reservaForm.jsp").forward(request, response);
	}

	

}
