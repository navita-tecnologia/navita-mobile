package br.com.navita.mobile.duke.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author marcio.guedes
 *
 */
public class Chamado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numero;
	private Cliente solicitante;
	private String usuarioAtendido;
	private String abertura;
	private String resumo;
	private String descricao;
	private String prioridade;
	private String status;
	private String categoria;
	private String produto;
	private String processo;
	private String tipo;
	private String analista;
	private List<FormPair> formData;	
	
	public Chamado(String numero, String solicitante) {
		this.numero = numero;
		this.solicitante = new Cliente(solicitante);
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Cliente getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Cliente solicitante) {
		this.solicitante = solicitante;
	}
	public String getAbertura() {
		return abertura;
	}
	public void setAbertura(String abertura) {
		this.abertura = abertura;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getProcesso() {
		return processo;
	}
	public void setProcesso(String processo) {
		this.processo = processo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAnalista() {
		return analista;
	}
	public void setAnalista(String analista) {
		this.analista = analista;
	}
	public String getUsuarioAtendido() {
		return usuarioAtendido;
	}
	public void setUsuarioAtendido(String usuarioAtendido) {
		this.usuarioAtendido = usuarioAtendido;
	}
	public List<FormPair> getFormData() {
		return formData;
	}
	public void setFormData(List<FormPair> formData) {
		this.formData = formData;
	}
	
	
}
