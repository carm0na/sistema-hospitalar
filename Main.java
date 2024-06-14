package SistemaHospitalar;

import java.util.Scanner;
import java.util.LinkedList;

public class Main { //menu do Enfermeiro

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean temAtendimento = true;
        LinkedList<Paciente> filaAtendimento = new LinkedList<>(); // Usamos LinkedList para permitir inserção em qualquer posição

        while (temAtendimento) {
            System.out.println("BEM VINDO ENFERMEIRO! DIGITE UMA DAS OPÇÕES À SEGUIR:\n" +
                    "1 - Cadastrar Paciente.\n" + "2 - Atender Paciente. ");

            int menu = scanner.nextInt();

            switch (menu) {
                case 1: //cadastrar paciente
                    cadastrarPaciente(filaAtendimento, scanner);
                    break;

                case 2: // atender paciente
                    atenderPaciente(filaAtendimento);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void cadastrarPaciente(LinkedList<Paciente> filaAtendimento, Scanner scanner) {
        Paciente novoPaciente = new Paciente();

        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();
        novoPaciente.setNome(nome);

        System.out.println("Digite o CPF: ");
        String cpf = scanner.nextLine();
        novoPaciente.setCpf(cpf);

        System.out.println("Digite o telefone: ");
        String telefone = scanner.nextLine();
        novoPaciente.setTelefone(telefone);

        System.out.println("Digite o endereço: ");
        String endereco = scanner.nextLine();
        novoPaciente.setEndereco(endereco);

        System.out.println("Principais sintomas: ");
        String sintomas = scanner.nextLine();
        novoPaciente.setSintomas(sintomas);

        novoPaciente.setRisco();

        // Encontrar a posição correta para inserir o novo paciente
        int indiceInsercao = 0;
        while (indiceInsercao < filaAtendimento.size() && novoPaciente.getRisco() > filaAtendimento.get(indiceInsercao).getRisco()) {
            indiceInsercao++;
        }

        filaAtendimento.add(indiceInsercao, novoPaciente);

        System.out.println("Paciente cadastrado com sucesso, aguarde ser chamado.\n");
    }

    private static void atenderPaciente(LinkedList<Paciente> filaAtendimento) {
        if (!filaAtendimento.isEmpty()) {
            Paciente pacienteAtendido = filaAtendimento.removeFirst(); // Removemos o primeiro paciente da fila
            System.out.println("Atenção " + pacienteAtendido.getNome() + ", favor se dirigir ao consultório.");
        } else {
            System.out.println("Não há pacientes na fila para atendimento.");
        }
    }
}
