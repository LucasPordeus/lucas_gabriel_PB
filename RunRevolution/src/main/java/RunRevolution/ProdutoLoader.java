package RunRevolution;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import RunRevolution.model.domain.Produto;
import RunRevolution.model.domain.Roupa;
import RunRevolution.model.domain.Tenis;
import RunRevolution.model.domain.Relogio;
import RunRevolution.model.service.ProdutoService;

@Order(5)
@Component
public class ProdutoLoader implements ApplicationRunner {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/produto.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Produto produto;

            switch (campos[6]) {
                case "Roupa":
                    produto = new Roupa();
                    ((Roupa) produto).setTamanho(campos[7]);
                    ((Roupa) produto).setSexo(campos[8]);
                    ((Roupa) produto).setTipo(campos[9]);
                    break;
                case "Tenis":
                    produto = new Tenis();
                    ((Tenis) produto).setModelo(campos[7]);
                    ((Tenis) produto).setSexo(campos[8]);
                    ((Tenis) produto).setTamanho(Integer.valueOf(campos[9]));
                    break;
                case "Relogio":
                    produto = new Relogio();
                    ((Relogio) produto).setModelo(campos[7]);
                    ((Relogio) produto).setGps(Boolean.parseBoolean(campos[8]));
                    ((Relogio) produto).setResistenteAgua(Boolean.parseBoolean(campos[9]));
                    break;
                default:
                    produto = new Produto();
                    break;
            }

            produto.setNome(campos[0]);
            produto.setValor(Float.valueOf(campos[1]));
            produto.setQuantidade(Integer.valueOf(campos[2]));

            produtoService.incluir(produto);

            linha = leitura.readLine();
        }

        for (Produto produto : produtoService.obterLista()) {
            System.out.println("[PRODUTO] " + produto);
        }

        leitura.close();
    }
}