package com.files.PayementService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StripeRespone {

 	private String status;
	private String message;
	private String sessionId;
	private String sessionUrl;
	}
