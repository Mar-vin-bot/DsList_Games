package com.devsuperior.dslist.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.devsuperior.dslist.dto.GameListDTO;


import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repository.GameListRepository;


import jakarta.transaction.Transactional;

@Service
public class GameListService {
	
	@Autowired
	private  GameListRepository gameListRepository;
	
	@Transactional
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
		
	}
	

	
	
	
}
