package com.restaurante;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface = "com.restaurante.ProdutoServer")

public class ProdutoServerImpl implements ProdutoServer {
	private HashMap<Integer, Produto> produto = new HashMap<>();

	@Override
	public void adicionarProduto(int id, String nome, String descricao, int preco, String categoria) {
		Produto pro = new Produto(id, nome, descricao, preco, categoria);
		produto.put(id, pro);
	}

	@Override
	public Produto buscarProduto(int id) {
		try {
			return produto.get(id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public HashMap<Integer, Produto> listarProduto() {
		return this.produto;
	}

	@Override
	public String listarProdutoString() {
		String formatado = "";
		for (Map.Entry<Integer, Produto> entry : produto.entrySet()) {
			Integer key = entry.getKey();
			String nome = entry.getValue().getNome();
			String descricao = entry.getValue().getDescricao();
			int preco = entry.getValue().getPreco();
			String categoria = entry.getValue().getCategoria();
			formatado += ("id produto: " + key + ", Nome: " + nome + ", descricao: " + descricao + ", Preco: " + preco
					+ ", Categoria: " + categoria + "\n");
		}
		System.out.println(formatado);
		return formatado;
	}

	@Override
	public void atualizarProduto(int id, String nome, String descricao, int preco, String categoria) {
		produto.remove(id);
		Produto p = new Produto(id, nome, descricao, preco, categoria);
		produto.put(id, p);
	}

	@Override
	public void removerProduto(int id) {
		try {
			produto.remove(id);
		} catch (Exception e) {
			System.err.println("Deu ruim");
		}

	}

}
