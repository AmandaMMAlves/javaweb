package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@SuppressWarnings("serial")
@WebServlet (urlPatterns = "/login")
public class Login extends HttpServlet{
	
	/*final static Map<String, Usuario> USUARIOS_LOGADOS = new HashMap<>();
	
	public String login(Usuario usuario) //Preenchimento do HASHMAP e retorno do código do usuario
	{
		String codigo = System.currentTimeMillis() + "\\" + Math.random();
		USUARIOS_LOGADOS.put(codigo, usuario);
		return codigo;
		
	}*/
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		if (usuario == null) {
			writer.println("<html><body>Usuario e senha inválidos</body></html>");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("usuario.logado", usuario);
			writer.println("<html><body>Usuario " + email + " logado com sucesso</body></html>");
		}
		
		
	}

}
