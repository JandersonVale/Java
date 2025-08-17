import java.util.Scanner;

public class SudokuGame {
    static int[][] board = new int[9][9];
    static boolean[][] fixed = new boolean[9][9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Processa args (ex: "0,0,5 1,1,3 4,4,7")
        for (String arg : args) {
            String[] parts = arg.split(",");
            if (parts.length == 3) {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                int num = Integer.parseInt(parts[2]);
                board[row][col] = num;
                fixed[row][col] = true;
            }
        }

        int option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Iniciar novo jogo");
            System.out.println("2. Colocar um novo número");
            System.out.println("3. Remover um número");
            System.out.println("4. Verificar jogo");
            System.out.println("5. Verificar status do jogo");
            System.out.println("6. Limpar");
            System.out.println("7. Finalizar o jogo");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    iniciarJogo(args);
                    break;
                case 2:
                    inserirNumero(scanner);
                    break;
                case 3:
                    removerNumero(scanner);
                    break;
                case 4:
                    exibirTabuleiro();
                    break;
                case 5:
                    verificarStatus();
                    break;
                case 6:
                    limpar();
                    break;
                case 7:
                    finalizarJogo();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 7);
    }

    static void iniciarJogo(String[] args) {
        board = new int[9][9];
        fixed = new boolean[9][9];
        for (String arg : args) {
            String[] parts = arg.split(",");
            if (parts.length == 3) {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                int num = Integer.parseInt(parts[2]);
                board[row][col] = num;
                fixed[row][col] = true;
            }
        }
        System.out.println("Novo jogo iniciado.");
    }

    static void inserirNumero(Scanner scanner) {
        System.out.print("Digite o número (1-9): ");
        int num = scanner.nextInt();
        System.out.print("Linha (0-8): ");
        int row = scanner.nextInt();
        System.out.print("Coluna (0-8): ");
        int col = scanner.nextInt();

        if (fixed[row][col]) {
            System.out.println("Erro: Não é possível modificar um número fixo.");
        } else if (board[row][col] != 0) {
            System.out.println("Erro: Essa posição já está preenchida.");
        } else {
            board[row][col] = num;
            System.out.println("Número inserido com sucesso.");
        }
    }

    static void removerNumero(Scanner scanner) {
        System.out.print("Linha (0-8): ");
        int row = scanner.nextInt();
        System.out.print("Coluna (0-8): ");
        int col = scanner.nextInt();

        if (fixed[row][col]) {
            System.out.println("Erro: Não é possível remover um número fixo.");
        } else if (board[row][col] == 0) {
            System.out.println("Erro: Essa posição já está vazia.");
        } else {
            board[row][col] = 0;
            System.out.println("Número removido com sucesso.");
        }
    }

    static void exibirTabuleiro() {
        System.out.println("\nTabuleiro atual:");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) System.out.println("---------------------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) System.out.print("| ");
                System.out.print((board[i][j] == 0 ? "." : board[i][j]) + " ");
            }
            System.out.println();
        }
    }

    static void verificarStatus() {
        boolean iniciado = false, completo = true, erros = false;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) iniciado = true;
                if (board[i][j] == 0) completo = false;
                if (board[i][j] != 0 && !posicaoValida(i, j, board[i][j])) erros = true;
            }
        }

        String status = !iniciado ? "Não iniciado" : (completo ? "Completo" : "Incompleto");
        System.out.println("Status: " + status);
        System.out.println("Erros: " + (erros ? "Sim" : "Não"));
    }

    static boolean posicaoValida(int row, int col, int num) {
        // Verifica linha e coluna
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == num) return false;
            if (i != row && board[i][col] == num) return false;
        }

        // Verifica bloco 3x3
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if ((i != row || j != col) && board[i][j] == num) return false;
            }
        }

        return true;
    }

    static void limpar() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (!fixed[i][j]) board[i][j] = 0;
        System.out.println("Todos os números inseridos pelo usuário foram removidos.");
    }

    static void finalizarJogo() {
        boolean completo = true;
        boolean erros = false;

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) completo = false;
                else if (!posicaoValida(i, j, board[i][j])) erros = true;
            }

        if (!completo) {
            System.out.println("O jogo não está completo. Preencha todos os espaços.");
        } else if (erros) {
            System.out.println("O jogo está completo, mas contém erros.");
        } else {
            System.out.println("Parabéns! Você completou o Sudoku corretamente!");
        }
    }
}
