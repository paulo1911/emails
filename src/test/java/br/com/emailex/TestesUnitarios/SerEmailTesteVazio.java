package br.com.emailex.TestesUnitarios;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.emailex.ServEmail;
import junit.framework.TestCase;

public class SerEmailTesteVazio extends TestCase {
	private ServEmail sm=new ServEmail();
	@Rule
	public ExpectedException except= ExpectedException.none();

		@Test
		public void testServEmailMensagemVazio() {
			String remetente="apptosendemail@gmail.com";
			String destinatario="f.dutraaguiar@gmail.com";
			String assunto="Formulário de Contato do Sistema";
			String mensagem="";
			sm.servemail(remetente,destinatario,assunto,mensagem);
			Assert.assertNotNull(sm);
		}
		@Test
		public void testServEmailDestinatarioVazio() throws NullPointerException {
			String remetente="apptosendemail@gmail.com";
			String destinatario="";
			String assunto="Formulário de Contato do Sistema";
			String mensagem="";
			sm.servemail(remetente,destinatario,assunto,mensagem);
		}
		
		@Test
		public void testServEmailRemetenteVazio() throws NullPointerException {
			String remetente="";
			String destinatario="f.dutraaguiar@gmail.com";
			String assunto="Formulário de Contato do Sistema";
			String mensagem="";
			sm.servemail(remetente,destinatario,assunto,mensagem);
		}

}
