package br.com.rouparia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="itempedido_id", sequenceName="itempedido_seq", allocationSize=1)
public class ItemPedido extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="itempedido_id")
	private Long id;
	
	private int quantidade;
	
	@ManyToOne
	private Peca peca;
	
	@ManyToOne
	private Pedido pedido;
	

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setCardapio(Peca peca) {
		this.peca = peca;
	}
	

}
