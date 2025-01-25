package com.devsuperior.dslist.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.dslist.dto.GameDTO;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;

import com.devsuperior.dslist.projections.GameMinProjection;

import com.devsuperior.dslist.repository.GameRepository;

import jakarta.transaction.Transactional;

@Service
public class GameService {
	

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public GameDTO findById(@PathVariable Long listId) {
		Game result = gameRepository.findById(listId).get();
		return new GameDTO(result);
	}
	
	@Transactional
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO()).toList();
	}
	

	
	@Transactional
	public List<GameMinDTO> findByGameList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	/*
	@Transactional
	public List<GameMinDTO> findByGameList(Long listId) {
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		return games.stream().map(GameMinDTO::new).toList();
	}
	
	*/
	
	
	
	
}
