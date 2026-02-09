public record Circulo(double raio) implements FormasGeometricas{

    private static double pi = 3.14;

    @Override
    public double calcularArea() {
        return pi * Math.pow(raio,2);
    }
}
