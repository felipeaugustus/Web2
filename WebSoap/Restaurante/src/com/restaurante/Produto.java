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
		if (nome.length() > 0) {
			this.nome = nome;
		} else {
			throw new IllegalArgumentException("Nome invalido");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao.length() > 0) {
			this.descricao = descricao;
		} else {
			throw new IllegalArgumentException("Descricao invalido");
		}
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		if (preco > 0) {
			this.preco = preco;
		} else {
			throw new IllegalArgumentException("Preco invalido");
		}
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		if (categoria.length() > 0) {
			this.categoria = categoria;
		} else {
			throw new IllegalArgumentException("Categoria invalida");
		}
	}
}