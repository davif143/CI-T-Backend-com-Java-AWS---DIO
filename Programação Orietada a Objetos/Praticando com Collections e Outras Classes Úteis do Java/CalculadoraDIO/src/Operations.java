public enum Operations {

    SOMA("+"){
        @Override
        public double calcular(double a, double b) {
            return a + b;
        }
    },
    SUBTRACAO("-"){
        @Override
        public double calcular(double a, double b) {
            return a - b;
        }
    },
    MULTIPLICACAO("*"){
        @Override
        public double calcular(double a, double b) {
            return a * b;
        }
    },
    DIVISAO("/"){
        @Override
        public double calcular(double a, double b) {
            return a / b;
        }
    };

    private final String simbolo;

    Operations(String simbolo) {
        this.simbolo = simbolo;
    }

    public abstract double calcular(double a, double b);

    public String getSimbolo() {
        return simbolo;
    }
}
