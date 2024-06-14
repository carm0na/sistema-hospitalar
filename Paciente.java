package SistemaHospitalar;

import java.util.Scanner;
import java.util.ArrayList;
class Paciente {
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String sintomas;
    private int risco;

    Scanner scanner = new Scanner(System.in);

    // Métodos de cadastro do paciente
    public void setNome() {
        System.out.println("Digite o nome: ");
        nome = scanner.nextLine();
    }

    public void setCpf() {
        System.out.println("Digite o CPF: ");
        cpf = scanner.nextLine();
    }

    public void setTelefone() {
        System.out.println("Digite o telefone: ");
        telefone = scanner.nextLine();
    }

    public void setEndereco() {
        System.out.println("Digite o endereço: ");
        endereco = scanner.nextLine();
    }

    public void setSintomas() {
        System.out.println("Principais sintomas: ");
        sintomas = scanner.nextLine();
    }

    public void setRisco() {
        while (true) {
            try {
                System.out.print("Risco (de 1 a 5): ");
                int risco = Integer.parseInt(scanner.nextLine());

                if (risco < 1 || risco > 5) {
                    throw new IllegalArgumentException("Entrada inválida. Enfermeiro, classifique o risco como:\n" +
                            "1 - Casos de emergência;\n" + "2 - Casos muito urgentes;\n" + "3 - Casos de urgência;\n" +
                            "4 - Casos pouco urgentes;\n" + "5 - Casos não urgentes.\n");
                }

                this.risco = risco;
                System.out.println("Você digitou: " + risco);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro: Você deve digitar um número inteiro.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public int getRisco() {
        return risco;
    }

    public String getNome() {
        return nome;
    }
}