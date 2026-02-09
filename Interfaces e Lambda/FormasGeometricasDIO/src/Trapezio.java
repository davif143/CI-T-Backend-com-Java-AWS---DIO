public record Trapezio(double baseMenor, double baseMaior, double altura) implements FormasGeometricas {
    @Override
    public double calcularArea() {
        return ((baseMaior * baseMenor) * altura)/2;
    }
}
