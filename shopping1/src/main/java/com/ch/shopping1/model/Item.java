package com.ch.shopping1.model;

import lombok.Data;

@Data
public class Item {
	private int itemId;
	private String itemName;
	private int price;
	private String description;
	private String pictureUrl;
}
