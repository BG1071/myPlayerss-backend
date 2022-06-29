package com.example.myplayerss;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface myTeam extends CrudRepository<myPlayers, Long> {

}
