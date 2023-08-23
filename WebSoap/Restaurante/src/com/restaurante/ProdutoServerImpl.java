package com.restaurante;

import java.util.HashMap;

import javax.jws.WebService;

@WebService(endpointInterface = "com.restaurante.ProdutoServer")

public class ProdutoServerImpl implements ProdutoServer {
	private HashMap<Integer, Produto> produto = new HashMap<>();

	@Override
	public void AdicionarProduto(int id, String nome, String descricao, int preco, String categoria) {
		Produto pro = new Produto(id, nome, descricao, preco, categoria);
		produto.put(id, pro);
	}

	@Override
	public Produto BuscarProduto(int id) {
		try {
			return produto.get(id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public HashMap<Integer, Produto> ListarProduto() {
		return this.produto;
	}

	@Override
	public void AtualizarProduto(int id, String nome, String descricao, int preco, String categoria) {
		produto.remove(id);
		Produto p = new Produto(id, nome, descricao, preco, categoria);
		produto.put(id, p);

	}

	@Override
	public void RemoverProduto(int id) {
		try {
			produto.remove(id);
		} catch (Exception e) {
			System.err.println("Deu ruim");
		}

	}

}
