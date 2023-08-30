package com.restaurante;

import java.util.HashMap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ProdutoServer {
	@WebMethod
	void adicionarProduto(int id, String nome, String descricao, int preco, String categoria);

	@WebMethod
	Produto buscarProduto(int id);

	@WebMethod
	HashMap<Integer, Produto> listarProduto();

	@WebMethod
	void atualizarProduto(int id, String nome, String descricao, int preco, String categoria);

	@WebMethod
	void removerProduto(int id);

	@WebMethod
	public String listarProdutoString();
}