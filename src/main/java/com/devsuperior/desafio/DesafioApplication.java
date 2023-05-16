package com.devsuperior.desafio;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;
import com.devsuperior.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class DesafioApplication  implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Código: ");
		int codigo = sc.nextInt();

		System.out.print("Valor básico: ");
		double valor = sc.nextDouble();

		System.out.print("Porcentagem de desconto: ");
		double desconto = sc.nextDouble();

		Order order = new Order(codigo, valor, desconto);

		double total = orderService.total(order);

		System.out.println("Pedido código: " + order.getCode());
		System.out.println("Valor total: " + String.format("%.2f", total));

		sc.close();
	}
}
