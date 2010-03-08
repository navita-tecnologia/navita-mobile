package br.com.navita.mobile.duke.domain;

import java.io.Serializable;

/**
 * 
 * @author marcio.guedes
 *
 */
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	private String setor;
	
	public Cliente(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(id);
		if(nome != null){
			buffer.append(" (").append(nome);
			if(setor != null){
				buffer.append(" - ").append(setor);
			}
			buffer.append(")");
		}else{
			if(setor != null){				
				buffer.append(" (").append(setor).append(")");
			}
		}		
		return buffer.toString();
		
	}
}
