package SistemaHospitalar;

import java.util.Scanner;
import java.util.ArrayList;

public class Main { //menu do Enfermeiro

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean temAtendimento = true;
        ArrayList<Paciente> filaAtendimento = new ArrayList<>();

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

    private static void cadastrarPaciente(ArrayList<Paciente> filaAtendimento, Scanner scanner) {
        Paciente novoPaciente = new Paciente();

        novoPaciente.setNome();
        novoPaciente.setCpf();
        novoPaciente.setTelefone();
        novoPaciente.setEndereco();
        novoPaciente.setSintomas();
        novoPaciente.setRisco();

        int indiceInsercao = 0;
        for (Paciente paciente : filaAtendimento) {
            if (novoPaciente.getRisco() > paciente.getRisco()) {
                break;
            }
            indiceInsercao++;
        }
        filaAtendimento.add(indiceInsercao, novoPaciente);

        System.out.println("Paciente cadastrado com sucesso, aguarde ser chamado.\n");
    }

    private static void atenderPaciente(ArrayList<Paciente> filaAtendimento) {
        if (!filaAtendimento.isEmpty()) {
            Paciente pacienteAtendido = filaAtendimento.remove(0);
            System.out.println("Atenção " + pacienteAtendido.getNome() + ", favor se dirigir ao consultório.");
        } else {
            System.out.println("Não há pacientes na fila para atendimento.");
        }
    }
}