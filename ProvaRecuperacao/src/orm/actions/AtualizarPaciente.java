package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import orm.model.Paciente;

public class AtualizarPaciente {
	public static void main(String[] args) {
		Paciente paciente = new Paciente();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("insira o ID do paciente: ");
			paciente.setId(sc.nextLong());
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("pacientes");
			EntityManager manager = factory.createEntityManager();
			
			paciente = manager.find(Paciente.class, paciente.getId());
			if (paciente != null) {
				
				System.out.println(paciente.toString());
				System.out.println("\n\ninsira as informações do paciente a serem atualizadas:\n(Deixe em branco para manter o valor atual)");
				
				sc.nextLine();
				System.out.println("\nNome: ");
				String nome = sc.nextLine();
				if (!nome.isBlank()) {
					paciente.setNome(nome);
				}

				System.out.println("CPF: ");
				String cpf = sc.nextLine();
				if (!cpf.isBlank()) {
					paciente.setCPF(cpf);
				}
				
				System.out.println("Peso: ");
				String peso = sc.nextLine();
				if (!peso.isBlank()) {
					paciente.setPeso(peso);
				}

				System.out.println("Email: ");
				String email = sc.nextLine();
				if (!email.isBlank()) {
					paciente.setEmail(email);
				}

				System.out.println("Endereço: ");
				String endereco = sc.nextLine();
				if (!endereco.isBlank()) {
					paciente.setEndereco(endereco);
				}

				System.out.println("Naturalidade: ");
				String naturalidade = sc.nextLine();
				if (!naturalidade.isBlank()) {
					paciente.setNaturalidade(naturalidade);
				}

				System.out.println("DataNascimento: ");
				String dataNascimento = sc.nextLine();
				if (!dataNascimento.isBlank()) {
					paciente.setDataNascimento(dataNascimento);
				}

				manager.getTransaction().begin();
				manager.merge(paciente);
				manager.getTransaction().commit();

				System.out.println("informações do paciente atualizadas");
				
			} else {
				System.out.println("paciente não encontrado");
			}
			sc.close();
			manager.close();
			factory.close();
		} catch (NumberFormatException e) {
			System.out.println("valor invalido");
		}
	}
}
