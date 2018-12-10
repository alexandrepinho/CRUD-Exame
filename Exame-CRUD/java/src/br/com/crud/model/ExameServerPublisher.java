package br.com.crud.model;

import javax.xml.ws.Endpoint;

public class ExameServerPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9876/exame", new ExameServerImpl());
	}
}
