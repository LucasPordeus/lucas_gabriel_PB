package RunRevolution;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import RunRevolution.model.domain.Tenis;
import RunRevolution.model.service.TenisService;

@Order(2)
@Component
public class TenisLoader implements ApplicationRunner {
    @Autowired
    private TenisService tenisService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/tenis.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Tenis tenis = new Tenis();
            tenis.setNome(campos[0]);
            tenis.setValor(Float.valueOf(campos[1]));
            tenis.setQuantidade(Integer.valueOf(campos[2]));
            tenis.setModelo((campos[3]));
            tenis.setSexo(campos[4]);
            tenis.setTamanho(Integer.valueOf(campos[5]));

            tenisService.incluir(tenis);

            linha = leitura.readLine();
        }

        for(Tenis roupa : tenisService.obterLista()) {
            System.out.println("[TENIS] " + roupa);
        }

        leitura.close();
    }
}
