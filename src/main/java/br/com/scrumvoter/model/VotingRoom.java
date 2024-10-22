package br.com.scrumvoter.model;

import java.util.Date;

import br.com.scrumvoter.dto.VotingRoomResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class VotingRoom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String roomUUID;

	private Date createdAt;

	public VotingRoom() {

	}

	public VotingRoom(Long id, String name, String roomUUID, Date createdAt) {
		this.id = id;
		this.name = name;
		this.roomUUID = roomUUID;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoomUUID() {
		return roomUUID;
	}

	public void setRoomUUID(String roomUUID) {
		this.roomUUID = roomUUID;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public VotingRoomResponseDTO parseVotingRoomResponse() {
		return new VotingRoomResponseDTO(this.getName(), this.getRoomUUID(), this.getCreatedAt());

	}
}
