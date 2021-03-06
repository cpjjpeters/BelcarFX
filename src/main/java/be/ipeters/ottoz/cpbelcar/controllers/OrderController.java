package main.java.be.ipeters.ottoz.cpbelcar.controllers;

import java.util.List;

import main.java.be.ipeters.ottoz.cpbelcar.domain.Order;
import main.java.be.ipeters.ottoz.cpbelcar.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/all")
	public List<Order> findAll(){
		return orderService.findAll();
	}
	@GetMapping("/{id}")
	public Order findById(@PathVariable(value="id") Integer id){
		return orderService.findById(id);
	}
	
	@PostMapping("/create")
	public void createOrder(@RequestBody Order order) {
		System.out.println("create: " +order);
		orderService.save(order);
	}
	@PostMapping("/update")
	public void updateOrder(@RequestBody Order order) {	
		orderService.update(order);
		
	}
	@PostMapping("/delete/{id}")
	public void deleteById(@PathVariable(value="id") Integer id) {
		orderService.deleteById(id);
	}

}
