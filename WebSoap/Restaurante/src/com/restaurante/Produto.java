package com.restaurante;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private int preco;
	private String categoria;

	public Produto(int id, String nome, String descricao, int preco, String categoria) {
		setCategoria(categoria);
		setDescricao(descricao);
		setId(id);
		setNome(nome);
		setPreco(preco);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}