package com.enterprise.course.entities.enums;

public enum OrderStatus {
	//colocamos os numeros para deixarmos com o numero que queremos e no futuro poder mudar a vontade
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code; //campo para o tipo enumerado para podermos dar os valores 0 1 etc
	
	
	//Construtor para o tipo enumerado
	private OrderStatus(int code) {
		
		this.code = code;
	
	}

	public int getCode() {
		return code;
	}
	
	//Static porque vai funcionar sem precisar instanciar
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) return value;
		}
	throw new IllegalArgumentException("Invalid OrderStatus Code!");
	}
	
	
}
