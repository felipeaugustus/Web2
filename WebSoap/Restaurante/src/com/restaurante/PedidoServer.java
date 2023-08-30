package com.restaurante;

import java.time.LocalDateTime;
import java.util.HashMap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface PedidoServer {

	@WebMethod
	void adicionarPedido(int numeroPedido, String dataHoraPedido, String status);

	@WebMethod
	Pedido buscarPedido(int numeroPedido);

	@WebMethod
	String listarPedidos();

	@WebMethod
	void atualizarPedido(int numeroPedido, LocalDateTime novoDataHoraPedido, String novoStatus);

	@WebMethod
	void removerPedido(int numeroPedido);

	@WebMethod
	public HashMap<Integer, Pedido> getPedidos();
	
	@WebMethod
	public void adicionarProduto(int idPedido, int id, String nome, String descricao, int preco, String categoria);
	
	@WebMethod
	public void removerProduto(int idPedido, int idProduto);
}