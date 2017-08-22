package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet (urlPatterns = "/executa")
public class Controller extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tarefa = req.getParameter("tarefa"); //Pego o nome da tarefa
		if (tarefa == null)
			throw new IllegalArgumentException("Você esqueceu de passar o parâmetro");
		
		try {
			String nomeClasse = "br.com.alura.gerenciador.web." + tarefa; 
			Class<?> type = Class.forName(nomeClasse);
			Tarefa instancia = (Tarefa) type.newInstance(); //Instancio a tarefa da classe x
			instancia.executa(req, resp); //executo a servlet da classe x
			
			String pagina = instancia.executa(req, resp);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}
