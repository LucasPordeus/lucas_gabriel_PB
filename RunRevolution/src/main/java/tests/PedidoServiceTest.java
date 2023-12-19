package tests;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class PedidoServiceTest {
    @Test
    public void testeListagem() throws IOException {
        URL url = new URL("http://localhost:8081/api/pedido/listar");
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");
        int responseCode = conexao.getResponseCode();
        assertEquals(200,responseCode);
    }
}