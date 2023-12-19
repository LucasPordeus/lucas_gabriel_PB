package RunRevolution.model.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;

@Entity
@JsonTypeName("Relogio")
public class Relogio extends Produto {
    private String modelo;
    private boolean gps;
    private boolean resistenteAgua;

    @Override
    public String toString() {

        return String.format("(%s) - modelo (%s) - GPS (%s) - Resistente a Água (%s)",
                super.toString(), modelo, gps, resistenteAgua
        );
    }

    public Relogio() {}

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isResistenteAgua() {
        return resistenteAgua;
    }

    public void setResistenteAgua(boolean resistenteAgua) {
        this.resistenteAgua = resistenteAgua;
    }

}
