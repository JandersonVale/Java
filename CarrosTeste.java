import java.util.Scanner;

public class CarrosTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String modelo = scanner.nextLine();
        int anoFabricacao = Integer.parseInt(scanner.nextLine());
        int anoAtual = Integer.parseInt(scanner.nextLine());

        boolean apto = Carro.verificarAptidao(anoFabricacao, anoAtual);

        if (apto) {
            System.out.printf("%s: Apto\n", modelo);
        } else {
            System.out.printf("%s: Nao apto\n", modelo);
        }

        scanner.close();
    }

    static class Carro {
        public static boolean verificarAptidao(int anoFabricacao, int anoAtual) {
            int idade = anoAtual - anoFabricacao;
            return idade <= 10;
        }
    }
}
