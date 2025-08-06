package dev.val.premier_zone.controller;

import dev.val.premier_zone.model.Player;
import dev.val.premier_zone.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getPlayers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String nation,
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String position
    ){
        if(team != null && position != null){
            return ResponseEntity.ok(playerService.getPlayersByTeamAndPosition(team, position));
        }
        else if(team != null){
            return ResponseEntity.ok(playerService.getPlayersFromTeam(team));
        }
        else if(position != null){
            return ResponseEntity.ok(playerService.getPlayersByPosition(position));
        }
        else if(name != null){
            return ResponseEntity.ok(playerService.getPlayersByName(name));
        }
        else if(nation != null){
            return ResponseEntity.ok(playerService.getPlayersByNation(nation));
        }
        return ResponseEntity.ok(playerService.getPlayers());
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player playerToAdd){
        Player newPlayer = playerService.addPlayer(playerToAdd);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
    }

    @PutMapping
    public ResponseEntity<?> updatePlayer(@RequestBody Player playerToUpdate){
        Player updatedPlayer = playerService.updatePlayer(playerToUpdate);
        if(updatedPlayer != null){
            return ResponseEntity.ok(updatedPlayer);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found");
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
        playerService.deletePlayer(playerName);
        return ResponseEntity.ok("Player deleted successfully");
    }
}
