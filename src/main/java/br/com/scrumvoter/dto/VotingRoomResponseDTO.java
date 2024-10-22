package br.com.scrumvoter.dto;

import java.util.Date;

public record VotingRoomResponseDTO(String name, String roomUUID, Date createdAt) {

}
