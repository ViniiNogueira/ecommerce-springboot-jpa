package com.vinicius.ecommerce.config;

import com.vinicius.ecommerce.entities.*;
import com.vinicius.ecommerce.entities.enums.PedidoStatus;
import com.vinicius.ecommerce.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRrepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
    public void run(String... args) throws Exception {

//        usuarios
        User u1 = new User(null, "Vinicius" , "vinicius@gmail.com" , "999999999","123456");
        User u2 = new User(null,"Joao" , "joao@gmail.com" , "9999999999" , "123456");

//        Pedidos
        Pedido pe1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
        Pedido pe2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),PedidoStatus.PAGO, u2);
        Pedido pe3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),PedidoStatus.AGUARDANDO_PAGAMENTO, u1);

//        Categoria
        Categoria cat1 = new Categoria(null, "Electronics");
        Categoria cat2 = new Categoria(null, "Books");
        Categoria cat3 = new Categoria(null, "Computers");

//        Produtos
        Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(u1,u2));
        pedidoRepository.saveAll(Arrays.asList(pe1,pe2,pe3));
        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat1);
        p2.getCategorias().add(cat3);
        p3.getCategorias().add(cat3);
        p4.getCategorias().add(cat3);
        p5.getCategorias().add(cat2);

        produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        ItemPedido ip1 = new ItemPedido(pe1, p1, 2, p1.getPreco());
        ItemPedido ip2 = new ItemPedido(pe1, p3, 1, p3.getPreco());
        ItemPedido ip3 = new ItemPedido(pe2, p3, 2, p3.getPreco());
        ItemPedido ip4 = new ItemPedido(pe3, p5, 2, p5.getPreco());

        itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3,ip4));
    }

    @Autowired
    private UserRepository userRepository;
}
