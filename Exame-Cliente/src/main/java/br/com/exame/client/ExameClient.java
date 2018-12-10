package br.com.exame.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.com.model.Exame;
import br.com.model.ExameServer;

public class ExameClient {
	public static void main(String args[]) throws Exception {
		URL url = new URL("http://127.0.0.1:9876/exame?wsdl");
		QName qname = new QName("http://model.crud.com.br/", "ExameServerImplService");
		Service ws = Service.create(url, qname);
		QName qport = new QName("http://model.crud.com.br/", "ExameServerImplPort");

		ExameServer exam = ws.getPort(qport,ExameServer.class);

		Exame exame = exam.busca(1);
		System.out.println("Nome do paciente: " + exame.getNomePaciente());

	}
}