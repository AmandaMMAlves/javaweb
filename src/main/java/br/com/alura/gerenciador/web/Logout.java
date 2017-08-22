package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet (urlPatterns = "/logout")
public class Logout extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter	writer = resp.getWriter();
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("usuario.logado") == null)
		{
			writer.println(AmandaPreguica.MensagemCorpoHTML("Não há nenhum usuário logado"));
		}
		else
		{
			session.removeAttribute("usuario.logado");			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
			dispatcher.forward(req, resp);
		}
		
		
	}

}
