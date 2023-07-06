package orm.actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.model.Paciente;

public class ListarPacientes {
	public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pacientes");
        EntityManager manager = factory.createEntityManager();

         
        String sql = "SELECT a FROM pacientes AS a";

        Query query = manager.createQuery(sql);

        @SuppressWarnings("unchecked")
        List<Paciente> lista = query.getResultList();
        
        for (Paciente paciente : lista) {
			System.out.println(paciente.toString());
		}
    }
}
