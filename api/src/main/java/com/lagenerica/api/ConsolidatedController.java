package com.lagenerica.api;

import java.util.ArrayList;

import com.lagenerica.api.DAO.ConsolidatedDAO;
import com.lagenerica.api.DTO.ConsolidatedDTO;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/consolidated")
public class ConsolidatedController {
    @GetMapping("")
	public ArrayList<ConsolidatedDTO> list(@RequestHeader("city") String city) {
		ConsolidatedDAO DAO = new ConsolidatedDAO(city);
		return DAO.list();
	}

    
}
