public class Carro extends Veiculo {
    public Carro(String marca, String modelo, int ano, double km, double valor, double potenciaMotor) {
        super(marca, modelo, ano, km, valor, potenciaMotor);
    }

    @Override
    public void ligar() {
        System.out.println("Ligando o carro " + getMarca() + " " + getModelo() + " com chave.");
    }
}
