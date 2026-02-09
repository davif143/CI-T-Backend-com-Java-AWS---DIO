public record Quadrado(double lado) implements FormasGeometricas{
    @Override
    public double calcularArea() {
        return Math.pow(lado,2);
    }
}
