
package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Convidado;

public class DAOConvidado extends DAO<Convidado>{

	public Convidado read (Object chave){
		try{
			String nome = (String) chave;
			TypedQuery<Convidado> q = manager.createQuery("select c from Convidado c where c.nome=:n", Convidado.class);
			q.setParameter("n", nome);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado 
	public List<Convidado> readAll(){
		TypedQuery<Convidado> q = manager.createQuery("select c from Convidado c  order by c.nome", Convidado.class);
		return  q.getResultList();
	}
	
}