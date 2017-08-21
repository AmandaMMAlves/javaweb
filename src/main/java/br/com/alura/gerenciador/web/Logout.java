package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "/logout")
public class Logout extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter	writer = resp.getWriter();
		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		if(cookie == null) {
			writer.println(AmandaPreguica.MensagemCorpoHTML("Usuario não estava logado!!!"));
			return;
		}
		cookie.setMaxAge(0);
		resp.addCookie(cookie);		
		writer.println(AmandaPreguica.MensagemCorpoHTML("Usuario deslogado com sucesso!"));
		
	}

}
