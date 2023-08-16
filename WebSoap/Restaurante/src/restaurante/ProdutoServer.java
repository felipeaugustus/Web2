package restaurante;
import javax.jws.WebService;
import java.util.HashMap;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
@WebService
@SOAPBinding(style = Style.RPC)
public interface ProdutoServer {
    @WebMethod
    void AdicionarProduto(int id, String nome, String descricao, int preco, String categoria);
    @WebMethod
    Produto BuscarProduto(int id);
    @WebMethod
    HashMap<Integer, Produto> ListarProduto();
    @WebMethod
    void AtualizarProduto(int id, String nome, String descricao, int preco, String categoria);
    @WebMethod
    void RemoverProduto(int id);
}	