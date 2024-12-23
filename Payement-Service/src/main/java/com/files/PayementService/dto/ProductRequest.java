package com.files.PayementService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
	private long amount;
	private long quantity;
	private String name;
	private String currency;

}
