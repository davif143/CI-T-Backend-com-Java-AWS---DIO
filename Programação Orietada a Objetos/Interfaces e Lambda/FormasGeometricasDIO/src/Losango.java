public record Losango(double diagonalMaior, double diagonalMenor) implements  FormasGeometricas {
    @Override
    public double calcularArea() {
        return (diagonalMaior * diagonalMenor)/2;
    }
}
