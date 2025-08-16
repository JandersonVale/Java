public class Moto extends Veiculo {
    public Moto(String marca, String modelo, int ano, double km, double valor, double potenciaMotor) {
        super(marca, modelo, ano, km, valor, potenciaMotor);
    }

    @Override
    public void ligar() {
        System.out.println("Ligando a moto " + getMarca() + " " + getModelo() + " com botão.");
    }
}
