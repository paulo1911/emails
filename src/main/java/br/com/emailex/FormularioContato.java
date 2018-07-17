package br.com.emailex;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/envioemail")
public class FormularioContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ServEmail sm;
	private HttpManipulation httpmanipulator;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger log=Logger.getLogger("br.com.emailex.FormularioContato");
		log.info("LOG EMAIL-EXERCICIO: ");
		log.warning(getServletName());
		log.getLevel();
		httpmanipulator.HttpPrep(request, response);
		}
	


}
