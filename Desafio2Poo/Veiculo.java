public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private double km;
    private double valor;
    private double potenciaMotor;

    public Veiculo(String marca, String modelo, int ano, double km, double valor, double potenciaMotor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.km = km;
        this.valor = valor;
        this.potenciaMotor = potenciaMotor;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public double getKm() { return km; }
    public double getValor() { return valor; }
    public double getPotenciaMotor() { return potenciaMotor; }

    public abstract void ligar();

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + marca + " " + modelo +
                " | Ano: " + ano +
                " | KM: " + km +
                " | Valor: R$" + valor +
                " | Potência: " + potenciaMotor + " cv";
    }
}
