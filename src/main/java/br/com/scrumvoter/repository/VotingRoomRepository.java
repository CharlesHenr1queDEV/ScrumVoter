package br.com.scrumvoter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scrumvoter.model.VotingRoom;

public interface VotingRoomRepository extends JpaRepository<VotingRoom, Long> {

}
