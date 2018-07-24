package br.com.emailex.TestesUnitarios;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.emailex.ServEmail;
import junit.framework.TestCase;

public class ServEmailTeste extends TestCase {
private ServEmail sm=new ServEmail();
@Rule
public ExpectedException except= ExpectedException.none();

	@Test
	public void testServEmailMensagemNull() {
		String remetente="apptosendemail@gmail.com";
		String destinatario="f.dutraaguiar@gmail.com";
		String assunto="Formulário de Contato do Sistema";
		String mensagem=null;
		sm.servemail(remetente,destinatario,assunto,mensagem);
		Assert.assertNotNull(sm);
	}
	@Test
	public void testServEmailDestinatarioNull() throws NullPointerException {
		String remetente="apptosendemail@gmail.com";
		String destinatario=null;
		String assunto="Formulário de Contato do Sistema";
		String mensagem="Teste";
		sm.servemail(remetente,destinatario,assunto,mensagem);
	}
}
