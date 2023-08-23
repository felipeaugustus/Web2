package com.restaurante;

import javax.xml.ws.Endpoint;

public class RestauranteServerPublisher {

	public static void main(String[] args) {

		System.out.println("rodando");
		Endpoint.publish("http://127.0.0.1:9876/restaurante/pedido", new PedidoServerImpl());
		Endpoint.publish("http://127.0.0.1:9876/restaurante/produto", new ProdutoServerImpl());
	}
}