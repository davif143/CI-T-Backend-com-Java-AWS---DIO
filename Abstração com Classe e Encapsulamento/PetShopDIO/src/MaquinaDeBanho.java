public class MaquinaDeBanho {

    private int agua;
    private int shampoo;
    private boolean temPet;
    private boolean estaLimpa;

    public MaquinaDeBanho() {
        this.agua = 30;
        this.shampoo = 10;
        this.temPet = false;
        this.estaLimpa = true;
    }

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public int getShampoo() {
        return shampoo;
    }

    public void setShampoo(int shampoo) {
        this.shampoo = shampoo;
    }

    public boolean isTemPet() {
        return temPet;
    }

    public void setTemPet(boolean temPet) {
        this.temPet = temPet;
    }

    public boolean isEstaLimpa() {
        return estaLimpa;
    }

    public void setEstaLimpa(boolean estaLimpa) {
        this.estaLimpa = estaLimpa;
    }
}
