package RunRevolution;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import RunRevolution.model.domain.Usuario;
import RunRevolution.model.domain.Endereco;
import RunRevolution.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/usuarios.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Usuario usuario = new Usuario();
            usuario.setNome(campos[0]);
            usuario.setLogin(campos[1]);
            usuario.setSenha(campos[2]);
            usuario.setAcesso(campos[3]);
            usuario.setEndereco(new Endereco(campos[4]));

            usuarioService.incluir(usuario);

            linha = leitura.readLine();
        }

        for(Usuario usuario : usuarioService.obterLista()) {
            System.out.println("[USUARIO] " + usuario);
        }

        leitura.close();
    }
}
