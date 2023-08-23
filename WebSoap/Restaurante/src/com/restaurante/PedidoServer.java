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
	void AdicionarPedido(int numeroPedido, String dataHoraPedido, String status);

	@WebMethod
	Pedido BuscarPedido(int numeroPedido);

	@WebMethod
	String ListarPedidos();

	@WebMethod
	void AtualizarPedido(int numeroPedido, LocalDateTime novoDataHoraPedido, String novoStatus);

	@WebMethod
	void RemoverPedido(int numeroPedido);

	@WebMethod
	public HashMap<Integer, Pedido> getPedidos();
	
	@WebMethod
	public void adicionarProduto(int idPedido, int id, String nome, String descricao, int preco, String categoria);
	
	@WebMethod
	public void removerProduto(int idPedido, int idProduto);
}