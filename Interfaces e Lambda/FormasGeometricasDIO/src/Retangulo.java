public record Retangulo(double base, double altura) implements FormasGeometricas{
    @Override
    public double calcularArea() {
        return (base * altura);
    }
}
