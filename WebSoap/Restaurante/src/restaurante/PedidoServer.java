package restaurante;
import javax.jws.WebService;

import java.time.LocalDateTime;
import java.util.HashMap;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
@WebService
@SOAPBinding(style = Style.RPC)
public interface PedidoServer {
    
  @WebMethod void AdicionarPedido(int numeroPedido, LocalDateTime dataHoraPedido, String status);
  @WebMethod Pedido BuscarPedido(int numeroPedido);
  @WebMethod HashMap<Integer, Pedido> ListarPedidos();
  @WebMethod void AtualizarPedido(int numeroPedido, LocalDateTime novoDataHoraPedido, String novoStatus);
  @WebMethod void RemoverPedido(int numeroPedido);
  
}