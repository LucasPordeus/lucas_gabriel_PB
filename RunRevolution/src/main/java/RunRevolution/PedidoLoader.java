package RunRevolution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import RunRevolution.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import RunRevolution.model.domain.Pedido;
import RunRevolution.model.domain.Produto;
import RunRevolution.model.domain.Usuario;
import RunRevolution.model.domain.Relogio;
import RunRevolution.model.domain.Roupa;
import RunRevolution.model.domain.Tenis;
import RunRevolution.model.service.PedidoService;

@Order(6)
@Component
public class PedidoLoader implements ApplicationRunner {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/pedidos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        Pedido pedido = null;

        while(linha != null) {
            campos = linha.split(";");

            switch (campos[0]) {
                case "P":

                    Integer usuarioId = Integer.valueOf(campos[3]);
                    Optional<Usuario> usuario = usuarioService.obterPorId(usuarioId);

                    pedido = new Pedido();
                    pedido.setDescricao(campos[1]);
                    pedido.setData(LocalDateTime.now());
                    pedido.setStatus(campos[2]);
                    pedido.setUsuario(usuario);
                    pedido.setProdutos(new ArrayList<Produto>());

                    break;

                case "R":
                    Relogio relogio = new Relogio();
                    relogio.setId(Integer.valueOf(campos[1]));

                    pedido.getProdutos().add(relogio);

                    break;

                case "RP":
                    Roupa roupa = new Roupa();
                    roupa.setId(Integer.valueOf(campos[1]));

                    pedido.getProdutos().add(roupa);

                    break;

                case "T":
                    Tenis tenis = new Tenis();
                    tenis.setId(Integer.valueOf(campos[1]));

                    pedido.getProdutos().add(tenis);

                    break;

                default:
                    break;
            }

            linha = leitura.readLine();
        }

        pedidoService.incluir(pedido);


        for(Pedido p : pedidoService.obterLista()) {
            System.out.println("[PEDIDO] " + p);
        }

        leitura.close();
    }
}
