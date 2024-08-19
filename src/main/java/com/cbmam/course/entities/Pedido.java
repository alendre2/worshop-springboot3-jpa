package com.cbmam.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.cbmam.course.entities.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;

    private Integer statusPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemDoPedido> items = new HashSet<>();
    
    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;
    
    public Pedido() {
    }

    public Pedido(Long id, Instant momento, StatusPedido statusPedido, Usuario cliente) {
        this.id = id;
        this.momento = momento;
        this.setStatusPedido(statusPedido);
        this.cliente = cliente;
    }

    // Getters e Setters
    
    public StatusPedido getStatusPedido() {
        return StatusPedido.valorDe(statusPedido);
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        if (statusPedido != null) {
            this.statusPedido = statusPedido.getCodigo();
        }
    }

    public Set<ItemDoPedido> getItems() {
        return items;
    }
    
    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    public Double getTotal() {
        double soma = 0;
        for (ItemDoPedido x : items) {
            soma += x.getSubTotal();
        }
        return soma;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pedido other = (Pedido) obj;
        return Objects.equals(id, other.id);
    }
}
