package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Paciente;

public class RemoverPaciente {
	public static void main(String[] args) {
        Paciente paciente = new Paciente();
		Scanner sc = new Scanner(System.in);
        
        try {
			
        	System.out.println("insira a ID do paciente: ");
        	paciente.setId(sc.nextLong());
        	
        	EntityManagerFactory factory = Persistence.createEntityManagerFactory("pacientes");
        	EntityManager manager = factory.createEntityManager();
        	
        	paciente = manager.find(Paciente.class, paciente.getId());
        	if (paciente != null) {
        		
        		manager.getTransaction().begin();
        		manager.remove(paciente);
        		manager.getTransaction().commit();
        		
        		System.out.println("paciente Excluido");
        	}else {
        		System.out.println("paciente não encontrado");
        	}
        	manager.close();
        	factory.close();
		} catch (Exception e) {
			System.out.println("valor invalido");
		}
        sc.close();
        
    }
}
