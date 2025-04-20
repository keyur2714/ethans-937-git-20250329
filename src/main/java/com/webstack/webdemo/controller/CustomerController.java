package com.webstack.webdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webstack.webdemo.dto.CustomerDTO;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://3.110.47.123:81/")
public class CustomerController {

	List<CustomerDTO> customers = new ArrayList<>();

	@GetMapping("/list")
	public List<CustomerDTO> list() {
		CustomerDTO customerDTO1 = new CustomerDTO(11l, "Keyur", "Pune", "7387029671", "keyurjava27@gmail.com");
		CustomerDTO customerDTO2 = new CustomerDTO(12l, "Denish", "Surat", "7387029661", "denishjava26@gmail.com");
		CustomerDTO customerDTO3 = new CustomerDTO(13l, "Vinit", "Bardoli", "7387029771", "vinitjava26@gmail.com");
		CustomerDTO customerDTO4 = new CustomerDTO(14l, "Shekhar", "Surat", "7387029991", "shekharjava26@gmail.com");
		CustomerDTO customerDTO5 = new CustomerDTO(15l, "Piyush", "Pune", "7387029001", "piyushjava26@gmail.com");
		
		
		customers.add(customerDTO1);
		customers.add(customerDTO2);
		customers.add(customerDTO3);
		customers.add(customerDTO4);
		customers.add(customerDTO5);
		
		return customers;
	}

	@GetMapping("/list/{id}/{name}")
	public CustomerDTO get(@PathVariable Long id, @PathVariable("name") String cname) {
		System.out.println(id + " " + cname);
		return customers.stream().filter(c -> c.getId() == id && c.getName().equals(cname)).collect(Collectors.toList())
				.get(0);
	}

	@GetMapping("/listByAddress")
	public CustomerDTO getByCity(@RequestParam("caddress") String address) {
		System.out.println(address);
		return customers.stream().filter(c -> c.getAddress().equals(address)).collect(Collectors.toList()).get(0);
	}

	@PostMapping("/save")
	public CustomerDTO save(@RequestBody CustomerDTO customerDTO) {
		customers.add(customerDTO);
		return customerDTO;
	}
}
