package br.com.emailex;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.emailex.interfaces.EmailStruct;

@Named
public class HttpManipulation implements EmailStruct {
	@Inject private ServEmail sm;
	@Inject private HeaderRequisitionManipulator hrm;
	private static final Logger logger = LogManager.getLogger(HttpManipulation.class);
	public HttpManipulation() {

	}

	public void HttpPrep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Iniciando teste de LOG DA CLASSE HttpManipulation");
		String IP = request.getHeader("X-FORWARDED-FOR");
		if (IP == null) {
			IP = request.getRemoteAddr();
		}
		Date datahoje = new Date();
		String toDay = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(datahoje);
		response.setContentType("text/html");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String mensagem = (String) request.getParameter("msg");
		String mensagemfinal = "De: " + nome + "\n" + "E-mail: " + email + "\n" + "Telefone: " + telefone + "\n"
				+ "Mensagem: " + mensagem + "\n\n\n" + "Dados de Acesso\n" + "Enviado de: " + hrm.getDeviceUser(request)+ "\n"
				+ "User Agent: " + request.getHeader("user-agent") + "\n" + "IP: " + IP + "\n" + "Em: " + toDay;
		sm.servemail("apptosendemail@gmail.com", "f.dutraaguiar@gmail.com", "Formulário de Contato do Sistema", mensagemfinal);
		RequestDispatcher rd=request.getRequestDispatcher("/FormularioContato.html");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			logger.info("Ocorreceu uma falha inesperada. Contate o administrador do sistema para maiores informações\nErro: "+e);
		}
		logger.info("Finalizando e retornando para o formulário");
	}

}
