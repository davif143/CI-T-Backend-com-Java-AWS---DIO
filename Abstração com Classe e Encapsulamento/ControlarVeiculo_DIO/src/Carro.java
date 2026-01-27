public class Carro {
    private int velocidade;
    private int marcha;
    private boolean status;

    public Carro() {
        this.status = false;
        this.velocidade = 0;
        this.marcha = 0;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
