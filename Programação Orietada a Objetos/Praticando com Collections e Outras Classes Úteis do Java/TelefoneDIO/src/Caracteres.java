public enum Caracteres {

    CARACTERES(new String[]{
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "(", ")", "-"
    });

    private final String[] caracteres;

    Caracteres(String[] caracteres) {
        this.caracteres = caracteres;
    }

    public String[] getCaracteres() {
        return caracteres;
    }

    public static boolean verificarCaracteres(String caracter) {
        for (Caracteres c : Caracteres.values()) {
            for (String carac : c.getCaracteres()) {
                if (carac.equalsIgnoreCase(caracter)) {
                    return true;
                }
            }
        }
        return false;
    }
}
