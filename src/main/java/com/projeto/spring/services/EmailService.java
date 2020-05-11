package com.projeto.spring.services;

import org.springframework.mail.SimpleMailMessage;

import com.projeto.spring.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);	
	
	void sendEmail(SimpleMailMessage msg);
	

}
