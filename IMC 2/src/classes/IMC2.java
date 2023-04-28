package classes;

import java.util.Scanner;
import java.util.Calendar;


public class IMC2 {
    public static void main (String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

    Pessoa[] pessoas = new Pessoa[10];
    int qtdePessoas = 0;
    boolean cadastroConcluido = false;

    while (!cadastroConcluido) {
        System.out.println("Cadastro de pessoa " + (qtdePessoas + 1));
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = sc.nextLine();

        String nomeCompleto = sobrenome.toUpperCase() + ", " + nome.toUpperCase();

        
        if (qtdePessoas > 0) {
            for (int i = 0; i < qtdePessoas; i++) {
                Pessoa pessoa = pessoas[i];
                if (pessoa.getNome().equals(nomeCompleto)) {
                    System.out.println("Erro: nome e sobrenome já cadastrados anteriormente.");
                    cadastroConcluido = true;
                    break;
                }
            }
        }

        if (!cadastroConcluido) {
            System.out.print("Data de nascimento (dd/mm/aaaa): ");
            String dataNascimentoStr = sc.nextLine();
            String[] dataNascimentoArr = dataNascimentoStr.split("/");
            int dia = Integer.parseInt(dataNascimentoArr[0]);
            int mes = Integer.parseInt(dataNascimentoArr[1]);
            int ano = Integer.parseInt(dataNascimentoArr[2]);
            Calendar dataNascimento = Calendar.getInstance();
            dataNascimento.set(ano, mes - 1, dia);

            System.out.print("Altura (em metros): ");
            double altura = sc.nextDouble();

            System.out.print("Peso (em kg): ");
            double peso = sc.nextDouble();

            sc.nextLine(); 

            Pessoa pessoa = new Pessoa(nome, sobrenome, dataNascimento, altura, peso);
            pessoa.setNome(nomeCompleto);
            pessoas[qtdePessoas] = pessoa;
            qtdePessoas++;

            System.out.println("Cadastro realizado com sucesso!\n");

            
            if (qtdePessoas == 10) {
                System.out.println("Limite de 10 cadastros atingido.");
                cadastroConcluido = true;
            }
        }
    }

    System.out.println("DADOS CADASTRADOS:");

    for (int i = 0; i < qtdePessoas; i++) {
        Pessoa pessoa = pessoas[i];
        System.out.println("\nCadastro " + (i + 1) + ":");
        System.out.println("Nome completo: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade() + " anos");
        System.out.println("Altura: " + pessoa.getAltura() + " m");
        System.out.println("Peso: " + pessoa.getPeso() + " kg");
        System.out.println("IMC: " + pessoa.getImc());
        pessoa.informaObesidade();
    }

    sc.close();
}
}
    