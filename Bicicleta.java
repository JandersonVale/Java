import java.util.Scanner;

// Classe principal
public class Bicicleta {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String modelo = scanner.nextLine();          // Lê o nome do modelo
        String nivelStr = scanner.nextLine();        // Lê o nível de bateria em String

        // Converte a string para inteiro
        int nivelBateria = Integer.parseInt(nivelStr);

        // Cria um objeto da classe BicicletaInterna com os valores lidos
        BicicletaInterna bicicleta = new BicicletaInterna(modelo, nivelBateria);

        // Chama o método que retorna a mensagem formatada e exibe no console
        System.out.println(bicicleta.obterMensagem());

        // Fecha o scanner (boa prática para liberar o recurso)
        scanner.close();
    }

    // Classe interna que representa a bicicleta
    static class BicicletaInterna {
        // Atributos privados
        private String modelo;
        private int nivelBateria;

        // Construtor
        public BicicletaInterna(String modelo, int nivelBateria) {
            this.modelo = modelo;
            this.nivelBateria = nivelBateria;
        }

        // Método para calcular a distância máxima estimada
        public double calcularDistancia() {
            return nivelBateria * 0.5;
        }

        // Método para gerar a mensagem de saída formatada
        public String obterMensagem() {
            return String.format("%s: Distancia estimada = %.1f km", modelo, calcularDistancia());
        }
    }
}
