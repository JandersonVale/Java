import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar Carro");
            System.out.println("2. Cadastrar Moto");
            System.out.println("3. Listar Veículos");
            System.out.println("4. Ligar Todos os Veículos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Carro ---");
                    veiculos.add(cadastrarVeiculo(scanner, "Carro"));
                    break;

                case 2:
                    System.out.println("\n--- Cadastro de Moto ---");
                    veiculos.add(cadastrarVeiculo(scanner, "Moto"));
                    break;

                case 3:
                    if (veiculos.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {
                        System.out.println("\nVeículos cadastrados:");
                        for (int i = 0; i < veiculos.size(); i++) {
                            System.out.println((i + 1) + ". " + veiculos.get(i));
                        }
                    }
                    break;

                case 4:
                    if (veiculos.isEmpty()) {
                        System.out.println("Nenhum veículo para ligar.");
                    } else {
                        System.out.println("\nLigando todos os veículos:");
                        for (Veiculo v : veiculos) {
                            v.ligar();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static Veiculo cadastrarVeiculo(Scanner scanner, String tipo) {
        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("KM rodados: ");
        double km = Double.parseDouble(scanner.nextLine().replace(",", "."));

        System.out.print("Valor (R$): ");
        double valor = Double.parseDouble(scanner.nextLine().replace(",", "."));

        System.out.print("Potência do motor (cv): ");
        double potencia = Double.parseDouble(scanner.nextLine().replace(",", "."));

        if (tipo.equalsIgnoreCase("Carro")) {
            return new Carro(marca, modelo, ano, km, valor, potencia);
        } else {
            return new Moto(marca, modelo, ano, km, valor, potencia);
        }
    }
}
