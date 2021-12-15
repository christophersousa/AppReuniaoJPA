
package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Convidado;
import modelo.Participante;
import modelo.Reuniao;

public class DAOReuniao extends DAO<Reuniao>{

	public Reuniao read (Object chave){
		try{
			int id = (int) chave;
			TypedQuery<Reuniao> q = manager.createQuery("select r from Reuniao r where r.id=:n", Reuniao.class);
			q.setParameter("n", id);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//  //pode-se sobrescrever o metodo readAll da classe DAO para ordenar o resultado 
	public List<Reuniao> readAll(){
		TypedQuery<Reuniao> q = manager.createQuery("select r from Reuniao r  order by r.id", Reuniao.class);
		return  q.getResultList();
	}
	
	public List<Participante> searchParticipantes(String nome, int mes){
		String c = "%/"+mes+"/%";
		TypedQuery<Participante> q = manager.createQuery("select distinct r.participantes from Reuniao r join Participante p on r.participantes.id = p.id where p.nome=:x and r.datahora like :y", Participante.class);
		q.setParameter("x", nome);
		q.setParameter("y", c);
		return  q.getResultList();
	}
	
	public List<Reuniao> meetinGuest(){
		TypedQuery<Reuniao> q = manager.createQuery("select distinct r from Reuniao r join Convidado p on r.participantes.id = p.id where p.empresa is not null", Reuniao.class);
		return  q.getResultList();
	}
	
}
