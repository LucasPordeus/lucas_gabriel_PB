package RunRevolution.model.domain;

import javax.persistence.Entity;

@Entity
public class Roupa extends Produto{

    private String tamanho;
    private String sexo;
    private String tipo;

    @Override
    public String toString() {

        return String.format("(%s) - Tamanho (%s) - Sexo (%s) - Tipo (%s)",
                super.toString(), tamanho, sexo, tipo
        );
    }

    public Roupa() {}

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
