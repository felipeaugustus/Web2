package restaurante;

import java.time.LocalDateTime;
import java.util.HashMap;
import javax.jws.WebService;

@WebService(endpointInterface = "restaurante.PedidoServer")
public class PedidoServerImpl implements PedidoServer {
	private HashMap<Integer, Pedido> pedidos = new HashMap<Integer, Pedido>();

	@Override
	public void AdicionarPedido(int numeroPedido, LocalDateTime dataHoraPedido, String status) {
		Pedido pedido = new Pedido(numeroPedido, dataHoraPedido, status);
		pedidos.put(numeroPedido, pedido);
	}

	@Override
	public Pedido BuscarPedido(int numeroPedido) {
		try {
			return pedidos.get(numeroPedido);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public HashMap<Integer, Pedido> ListarPedidos() {
		return this.pedidos;
	}

	@Override
	public void AtualizarPedido(int numeroPedido, LocalDateTime novoDataHoraPedido, String novoStatus) {
		pedidos.remove(numeroPedido);
		Pedido novoPedido = new Pedido(numeroPedido, novoDataHoraPedido, novoStatus);
		pedidos.put(numeroPedido, novoPedido);
	}

	@Override
	public void RemoverPedido(int numeroPedido) {
		try {
			pedidos.remove(numeroPedido);
		} catch (Exception e) {
			System.err.println("Deu ruim");
		}
	}

}