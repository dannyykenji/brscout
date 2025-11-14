package com.brscout.brscout.Service;

import com.brscout.brscout.Model.PlayerModel;
import com.brscout.brscout.Repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerModel> getPlayers() {
        return playerRepository.findAll();
    }

    public List<PlayerModel> getPlayersByTeam(String teamName){
        return playerRepository.findAll().stream()
                .filter(player -> player.getTeamName().toLowerCase().contains(teamName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<PlayerModel> getPlayersByName(String name) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<PlayerModel> getPlayersByPosition(String position){
        return playerRepository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains(position.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<PlayerModel> getPlayersByNation(String nation){
        return playerRepository.findAll().stream()
                .filter(player -> player.getNation() != null &&
                        player.getNation().toLowerCase().contains(nation.toLowerCase()))
                .collect(Collectors.toList());
    }

    public PlayerModel addPlayer(PlayerModel playerModel){
        playerRepository.save(playerModel);
        return playerModel;
    }

    public PlayerModel updatePlayer(PlayerModel updatedPlayerModel){
        Optional<PlayerModel> existingPlayer = playerRepository.findByName(updatedPlayerModel.getName());
        if(existingPlayer.isPresent()){
            PlayerModel playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayerModel.getName());
            playerToUpdate.setPosition(updatedPlayerModel.getPosition());
            playerToUpdate.setNation(updatedPlayerModel.getNation());
            playerToUpdate.setTeamName(updatedPlayerModel.getTeamName());
            playerToUpdate.setAge(updatedPlayerModel.getAge());
            playerToUpdate.setNumber(updatedPlayerModel.getNumber());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName){
        playerRepository.deleteByName(playerName);
    }
}
