package com.restaurante;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int numeroPedido;
	private LocalDateTime dataHoraPedido;
	private String status;
	private ArrayList<Produto> produtos;

	public Pedido(int numeroPedido, LocalDateTime dataHoraPedido, String status) {
		this.numeroPedido = numeroPedido;
		this.dataHoraPedido = dataHoraPedido;
		this.status = status;
		this.produtos = new ArrayList<>();
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		if (numeroPedido >= 0) {
			this.numeroPedido = numeroPedido;
		} else {
			throw new IllegalArgumentException("Número do Pedido Inválido");
		}
	}

	public LocalDateTime getDataHoraPedido() {
		return dataHoraPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status != null && !status.isEmpty()) {
			this.status = status;
		} else {
			throw new IllegalArgumentException("Status inválido");
		}
	}

	public List<Produto> getItens() {
		return produtos;
	}

	public String getItensString() {
		String formatada = "";
		for (int i = 0; i < produtos.size(); i++) {
			formatada += ("Id: " + produtos.get(i).getId() + " ");
			formatada += ("Nome: " + produtos.get(i).getNome() + " ");
		}
		return formatada;
	}

	public void addProduto(int id, String nome, String descricao, int preco, String categoria) {
		produtos.add(new Produto(id, nome, descricao, preco, categoria));
	}

	public void removerProduto(int id) {
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == i) {
				produtos.remove(i);
				System.out.println("Produto removido do pedido");
			}
		}
	}
}