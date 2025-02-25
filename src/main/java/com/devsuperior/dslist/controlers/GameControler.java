package com.devsuperior.dslist.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;

import com.devsuperior.dslist.service.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameControler {
	
	@Autowired
	private GameService gameService;	
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> resultGames = gameService.findAll();
		return resultGames;
	}
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = gameService.findById(id);
		return result;
	}
	

}