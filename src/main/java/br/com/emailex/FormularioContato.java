package br.com.emailex;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/envioemail")
public class FormularioContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private @Inject HttpManipulation httpmanipulator;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		httpmanipulator.HttpPrep(request, response);
	}

}
