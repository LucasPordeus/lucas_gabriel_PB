package RunRevolution.model.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;

@Entity
@JsonTypeName("Tenis")
public class Tenis extends Produto {

        private String modelo;
        private String sexo;
        private int tamanho;

    @Override
    public String toString() {

        return String.format("(%s) - Modelo (%s) - Sexo (%s) - Tamanho (%d)",
                super.toString(), modelo, sexo, tamanho
        );
    }

    public Tenis() {}

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }


}
