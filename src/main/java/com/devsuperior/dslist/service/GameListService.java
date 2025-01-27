package com.devsuperior.dslist.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.devsuperior.dslist.dto.GameListDTO;


import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repository.GameListRepository;
import com.devsuperior.dslist.repository.GameRepository;

import jakarta.transaction.Transactional;

@Service
public class GameListService {
	
	@Autowired
	private  GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
		
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinoIndex){
		
		List <GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinoIndex, obj);
		
		int min = sourceIndex < destinoIndex ? sourceIndex : destinoIndex;
		int max = sourceIndex < destinoIndex ? destinoIndex : sourceIndex;
		
		for(int i = min; i<= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
		
	}
	

	
	
	
}
