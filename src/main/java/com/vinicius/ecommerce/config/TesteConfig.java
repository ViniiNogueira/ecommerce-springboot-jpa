package com.vinicius.ecommerce.config;

import com.vinicius.ecommerce.entities.Categoria;
import com.vinicius.ecommerce.entities.Pedido;
import com.vinicius.ecommerce.entities.User;
import com.vinicius.ecommerce.entities.enums.PedidoStatus;
import com.vinicius.ecommerce.repositories.CategoriaRepository;
import com.vinicius.ecommerce.repositories.PedidoRepository;
import com.vinicius.ecommerce.repositories.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {

//        usuarios
        User u1 = new User(null, "Vinicius" , "vinicius@gmail.com" , "999999999","123456");
        User u2 = new User(null,"Joao" , "joao@gmail.com" , "9999999999" , "123456");

//        Pedidos
        Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
        Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),PedidoStatus.PAGO, u2);
        Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),PedidoStatus.AGUARDANDO_PAGAMENTO, u1);

        Categoria cat1 = new Categoria(null, "Electronics");
        Categoria cat2 = new Categoria(null, "Books");
        Categoria cat3 = new Categoria(null, "Computers");


        userRepository.saveAll(Arrays.asList(u1,u2));
        pedidoRepository.saveAll(Arrays.asList(p1,p2,p3));
        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
    }

    @Autowired
    private UserRepository userRepository;
}
