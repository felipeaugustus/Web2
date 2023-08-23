package com.restaurante;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface = "com.restaurante.PedidoServer")
public class PedidoServerImpl implements PedidoServer {
	private HashMap<Integer, Pedido> pedidos = new HashMap<>();

	@Override
	public void AdicionarPedido(int numeroPedido, String dataHoraPedidoStr, String status) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
		LocalDateTime dataHoraPedido = LocalDateTime.parse(dataHoraPedidoStr, formatter);

		Pedido pedido = new Pedido(numeroPedido, dataHoraPedido, status);
		pedidos.put(numeroPedido, pedido);
		System.out.println("Exito");
	}

	@Override
	public Pedido BuscarPedido(int numeroPedido) {
		try {
			return pedidos.get(numeroPedido);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public HashMap<Integer, Pedido> getPedidos() {
		return pedidos;
	}

	@Override
	public String ListarPedidos() {
		String formatado = "";
		for (Map.Entry<Integer, Pedido> entry : pedidos.entrySet()) {
			Integer key = entry.getKey();
			String status = entry.getValue().getStatus();
			String data = entry.getValue().getDataHoraPedido().toString();
			String produtos = entry.getValue().getItensString();
			formatado += ("Numero pedido: " + key + ", Status: " + status + ", Data: " + data + ", Produtos: "
					+ produtos + "\n");
		}
		System.out.println(formatado);
		return formatado;
	}

	@Override
	public void AtualizarPedido(int numeroPedido, LocalDateTime novoDataHoraPedido, String novoStatus) {
		pedidos.remove(numeroPedido);
		Pedido novoPedido = new Pedido(numeroPedido, novoDataHoraPedido, novoStatus);
		pedidos.put(numeroPedido, novoPedido);
	}

	@Override
	public void RemoverPedido(int numeroPedido) {
		try {
			pedidos.remove(numeroPedido);
		} catch (Exception e) {
			System.err.println("Deu ruim");
		}
	}

	@Override
	public void adicionarProduto(int idPedido, int id, String nome, String descricao, int preco, String categoria) {
		pedidos.get(idPedido).addProduto(id, nome, descricao, preco, categoria);
		System.out.println("Produto add do pedido");
	}

	@Override
	public void removerProduto(int idPedido, int idProduto) {
		pedidos.get(idPedido).removerProduto(idProduto);
		System.out.println("Produto removido do pedido");
	}

}