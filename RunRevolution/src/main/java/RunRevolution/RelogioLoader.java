package RunRevolution;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import RunRevolution.model.domain.Relogio;
import RunRevolution.model.service.RelogioService;

@Order(4)
@Component
public class RelogioLoader implements ApplicationRunner {
    @Autowired
    private RelogioService relogioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/relogios.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Relogio relogio = new Relogio();
            relogio.setNome(campos[0]);
            relogio.setValor(Float.valueOf(campos[1]));
            relogio.setQuantidade(Integer.valueOf(campos[2]));
            relogio.setModelo(campos[3]);
            relogio.setGps(Boolean.parseBoolean(campos[4]));
            relogio.setResistenteAgua(Boolean.parseBoolean(campos[5]));

            relogioService.incluir(relogio);

            linha = leitura.readLine();
        }

        for(Relogio relogio : relogioService.obterLista()) {
            System.out.println("[RELOGIO] " + relogio);
        }

        leitura.close();
    }
}
