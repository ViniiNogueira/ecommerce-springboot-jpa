package com.vinicius.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinicius.ecommerce.entities.enums.PedidoStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'" , timezone = "GMT")
    private Instant data;

    @ManyToOne
    @JoinColumn(name = "Cliente_Id")
    private User cliente;

    private Integer pedidoStatus;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {}

    public Pedido(Long id, Instant data,PedidoStatus pedidoStatus ,User cliente) {
        this.id = id;
        this.data = data;
        setPedidoStatus(pedidoStatus);
        this.cliente = cliente;
    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PedidoStatus getPedidoStatus() {
        return PedidoStatus.valor(pedidoStatus);
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        if (pedidoStatus != null) {
            this.pedidoStatus = pedidoStatus.getCodigo();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(getId(), pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
