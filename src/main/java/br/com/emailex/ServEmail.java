package br.com.emailex;

import java.util.Properties;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage; 


public class ServEmail {
	private String mailSMTPServer;
	private String mailSMTPServerPort;
	ServEmail() {
		mailSMTPServer = "smtp.gmail.com";
		mailSMTPServerPort = "465";
	}
	ServEmail(String mailSMTPServer, String mailSMTPServerPort) { //Para outro Servidor
		this.mailSMTPServer = mailSMTPServer;
		this.mailSMTPServerPort = mailSMTPServerPort;
	}
	
	@Inject
	public void servemail(String from, String to, String subject, String message) {
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.startssl.enable","true"); 
		props.put("mail.smtp.host", mailSMTPServer);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.user", from);
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", mailSMTPServerPort);
		props.put("mail.smtp.socketFactory.port", mailSMTPServerPort);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		SimpleAuth auth = null;
		auth = new SimpleAuth ("apptosendemail@gmail.com","testeenvioemail");
		Session session = Session.getDefaultInstance(props, auth);
		session.setDebug(true);
		Message msg = new MimeMessage(session);
		try {
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setFrom(new InternetAddress(from));
			msg.setSubject(subject);
			msg.setContent(message,"text/plain");
		} catch (Exception e) {
			System.out.println(">> Erro: Completar Mensagem");
			e.printStackTrace();
		}
		Transport tr;
		try {
			tr = session.getTransport("smtp");
			tr.connect(mailSMTPServer, "apptosendemail@gmail.com", "testeenvioemail");
			msg.saveChanges();
			tr.sendMessage(msg, msg.getAllRecipients());
			tr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(">> Erro: Envio Mensagem");
			e.printStackTrace();
		}
	}
}
//clase que retorna uma autenticacao para ser enviada e verificada pelo servidor smtp
class SimpleAuth extends Authenticator {
	public String username = null;
	public String password = null;
	public SimpleAuth(String user, String pwd) {
		username = user;
		password = pwd;
	}
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication (username,password);
	}
}