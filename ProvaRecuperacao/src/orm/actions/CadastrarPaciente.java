package orm.actions;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Paciente;

public class CadastrarPaciente {
	public static void main(String[] args) {
		Paciente paciente = new Paciente();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("insira as informações do novo paciente:\n");
		
		System.out.println("Nome: ");
		paciente.setNome(sc.nextLine());
		
		System.out.println("CPF: ");
		paciente.setCPF(sc.nextLine());
		
		System.out.println("Peso: ");
		paciente.setPeso(sc.nextLine());
		
		System.out.println("Email: ");
		paciente.setEmail(sc.nextLine());
		
		System.out.println("Endereço: ");
		paciente.setEndereco(sc.nextLine());
		
		System.out.println("Naturalidade: ");
		paciente.setNaturalidade(sc.nextLine());
		
		System.out.println("DataNascimento: ");
		paciente.setDataNascimento(sc.nextLine());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pacientes");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(paciente);
		manager.getTransaction().commit();
		
		System.out.println("paciente cadastrado! ID: "+paciente.toString());
		
		sc.close();
        manager.close();
        factory.close();
	}
}
