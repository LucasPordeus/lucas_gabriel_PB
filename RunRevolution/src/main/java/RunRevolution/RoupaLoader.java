package RunRevolution;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import RunRevolution.model.domain.Roupa;
import RunRevolution.model.service.RoupaService;

@Order(3)
@Component
public class RoupaLoader implements ApplicationRunner {
    @Autowired
    private RoupaService roupaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/roupas.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Roupa roupa = new Roupa();
            roupa.setNome(campos[0]);
            roupa.setValor(Float.valueOf(campos[1]));
            roupa.setQuantidade(Integer.valueOf(campos[2]));
            roupa.setTamanho((campos[3]));
            roupa.setSexo(campos[4]);
            roupa.setTipo(campos[5]);

            roupaService.incluir(roupa);

            linha = leitura.readLine();
        }

        for(Roupa roupa : roupaService.obterLista()) {
            System.out.println("[ROUPA] " + roupa);
        }

        leitura.close();
    }
}
