package com.cbmam.course.entities.enums;

public enum StatusPedido {
	
	ESPERANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static StatusPedido valorDe(int codigo) {
		for (StatusPedido value : StatusPedido.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido para StatusPedido: " + codigo);
	}
}
