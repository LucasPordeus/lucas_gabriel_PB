package RunRevolution.model.domain;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonTypeName;


@Entity
@JsonTypeName("Roupa")
public class Roupa extends Produto{

    private String tamanho;
    private String sexo;
    private String subtipo;

    @Override
    public String toString() {

        return String.format("(%s) - Tamanho (%s) - Sexo (%s) - subTipo (%s)",
                super.toString(), tamanho, sexo, subtipo
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

    public String getSubTipo() {
        return subtipo;
    }

    public void setSubTipo(String subtipo) {
        this.subtipo = subtipo;
    }

}
