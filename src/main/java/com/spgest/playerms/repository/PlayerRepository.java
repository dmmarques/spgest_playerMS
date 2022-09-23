package com.spgest.playerms.repository;

import com.spgest.playerms.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    public Optional<Player> getPlayerByEmail(String email);
}
