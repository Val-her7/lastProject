package dev.val.premier_zone.repository;

import dev.val.premier_zone.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

    void deleteByName(String name);

    Optional<Player> findByName(String name);
}
