import java.util.Random;
import java.util.Scanner;

public class App {

    public Opcoes gerarEscolhaComputador() {
        Random random = new Random();
        int escolha = random.nextInt(3);
        switch (escolha) {
            case 0: return Opcoes.PEDRA;
            case 1: return Opcoes.PAPEL;
            case 2: return Opcoes.TESOURA;
            default: return null;
        }
    }

    public boolean verificarVencedor(Opcoes usuario, Opcoes computador) {
        return (usuario == Opcoes.PEDRA && computador == Opcoes.TESOURA) ||
               (usuario == Opcoes.PAPEL && computador == Opcoes.PEDRA) ||
               (usuario == Opcoes.TESOURA && computador == Opcoes.PAPEL);
    }

    public void conferirOpcaoUsuario(String opcao) {
        try {
            Opcoes.valueOf(opcao.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Opção inválida! Escolha 'Pedra', 'Papel' ou 'Tesoura'.");
        }
    }

    public void jogarJokenpo() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Escolha uma opção: 'Pedra', 'Papel', 'Tesoura'");
            String inputUsuario = sc.nextLine().toUpperCase();
            conferirOpcaoUsuario(inputUsuario);

            Opcoes escolhaUsuario = Opcoes.valueOf(inputUsuario);
            Opcoes escolhaComputador = gerarEscolhaComputador();

            System.out.println("Você escolheu: " + escolhaUsuario);
            System.out.println("Computador escolheu: " + escolhaComputador);

            if (escolhaUsuario == escolhaComputador) {
                System.out.println("Empate!");
            } else if (verificarVencedor(escolhaUsuario, escolhaComputador)) {
                System.out.println("Você venceu!");
            } else {
                System.out.println("Computador venceu!");
            }
        }
    }

    public static void main(String[] args) {
        new App().jogarJokenpo();
    }
}