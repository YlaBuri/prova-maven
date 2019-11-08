package br.ucsal.lamis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.DAO.ReservaDAO;

/**
 * Servlet implementation class ReservaLista
 */
@WebServlet("/ReservaLista")
public class ReservaLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

    public ReservaLista() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("reservas", ReservaDAO.getReservas());
		request.getRequestDispatcher("reservaLista.jsp").forward(request, response);
	}

	

}
