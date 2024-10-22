package br.com.scrumvoter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.scrumvoter.dto.VotingRoomRequestDTO;
import br.com.scrumvoter.dto.VotingRoomResponseDTO;
import br.com.scrumvoter.services.VotingRoomService;

@RestController
@RequestMapping("voting-room")
public class VotingRoomController {

	private VotingRoomService votingRoomService;

	public VotingRoomController(VotingRoomService votingRoomService) {
		this.votingRoomService = votingRoomService;
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody VotingRoomRequestDTO votingRoom) {
		try {
			VotingRoomResponseDTO votingRoomResponseDTO = votingRoomService.create(votingRoom);

			return ResponseEntity.status(HttpStatus.CREATED).body(votingRoomResponseDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possivel criar uma sala de votação");
		}
	}
}
