package modelo;

import javax.persistence.Entity;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

@Entity 

public class Convidado extends Participante {
	private String empresa; 
	
	public Convidado() {};
	
	public Convidado(String nome, String email, String empresa) {
		super(nome, email);
		this.empresa=empresa;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() 	{
		String texto = super.toString() + "\n empresa="+empresa;
		return texto;
	}
}

