package br.com.emailex;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Named
@WebServlet("/envioemail")
public class FormularioContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private HttpManipulation httpmanipulator;
	private static final Logger logger = LogManager.getLogger(FormularioContato.class);
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	httpmanipulator.HttpPrep(request, response);
		

	}

}
