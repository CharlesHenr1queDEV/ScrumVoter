package br.com.scrumvoter.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.scrumvoter.dto.VotingRoomRequestDTO;
import br.com.scrumvoter.dto.VotingRoomResponseDTO;
import br.com.scrumvoter.model.VotingRoom;
import br.com.scrumvoter.repository.VotingRoomRepository;

@Service
public class VotingRoomService {

	private final Logger LOGGER = LogManager.getLogger(VotingRoomService.class);

	private VotingRoomRepository votingRoomRepository;

	public VotingRoomService(VotingRoomRepository votingRoomRepository) {
		this.votingRoomRepository = votingRoomRepository;
	}

	public VotingRoomResponseDTO create(VotingRoomRequestDTO votingRoom) {
		try {
			LOGGER.info("[VOTING_ROOM] Criando sala de votação");
			VotingRoom votingRoomCreated = votingRoomRepository.save(votingRoom.parseVotingRoom());

			LOGGER.info("[VOTING_ROOM] Sala de votação criada com sucesso");
			return votingRoomCreated.parseVotingRoomResponse();
		} catch (Exception e) {
			LOGGER.error("[VOTING_ROOM] Erro ao tentar criar a sala de votação" + e);
			throw e;
		}
	}

}
