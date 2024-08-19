package com.cbmam.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cbmam.course.entities.Categoria;
import com.cbmam.course.entities.ItemDoPedido;
import com.cbmam.course.entities.Pagamento;
import com.cbmam.course.entities.Pedido;
import com.cbmam.course.entities.Produto;
import com.cbmam.course.entities.Usuario;
import com.cbmam.course.entities.enums.StatusPedido;
import com.cbmam.course.repositories.CategoriaRepository;
import com.cbmam.course.repositories.ItemDoPedidoRepository;
import com.cbmam.course.repositories.PagamentoRepository;
import com.cbmam.course.repositories.PedidoRepository;
import com.cbmam.course.repositories.ProdutoRepository;
import com.cbmam.course.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemDoPedidoRepository itemDoPedidoRepository;
	
	@Autowired
    private PagamentoRepository pagamentoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		usuarioRepository.saveAll(Arrays.asList(u1, u2));

		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.ESPERANDO_PAGAMENTO, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.PAGO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.ENTREGUE, u1);
		
		pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));

		Produto p1 = new Produto(null, "O Senhor dos Anéis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails para Iniciantes", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	
		ItemDoPedido oi1 = new ItemDoPedido(o1, p1, 2, p1.getPreco());
		ItemDoPedido oi2 = new ItemDoPedido(o1, p3, 1, p3.getPreco());
		ItemDoPedido oi3 = new ItemDoPedido(o2, p3, 2, p3.getPreco());
		ItemDoPedido oi4 = new ItemDoPedido(o3, p5, 2, p5.getPreco());
		
		itemDoPedidoRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Pagamento pay1 = new Pagamento(null, Instant.parse("2019-07-21T21:42:10Z"),o2 );
		o2.setPagamento(pay1);
		
		pedidoRepository.save(o2);
	}
}
