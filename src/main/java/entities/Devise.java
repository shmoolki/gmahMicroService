package entities;

public class Devise {
    private String code;
    private String texte;
    private String sigle;

    public Devise(String code, String texte, String sigle) {
        this.code = code;
        this.texte = texte;
        this.sigle = sigle;
    }

    public Devise() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    @Override
    public String toString() {
        return "Devise{" +
                "code='" + code + '\'' +
                ", texte='" + texte + '\'' +
                ", sigle='" + sigle + '\'' +
                '}';
    }
}
