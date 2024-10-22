package br.com.scrumvoter.dto;

import java.util.Date;
import java.util.UUID;

import br.com.scrumvoter.model.VotingRoom;

public record VotingRoomRequestDTO(String name) {
	public VotingRoom parseVotingRoom() {
		VotingRoom votingRoom = new VotingRoom();
		votingRoom.setName(name);
		votingRoom.setCreatedAt(new Date());
		votingRoom.setRoomUUID(UUID.randomUUID().toString());

		return votingRoom;
	}
}
