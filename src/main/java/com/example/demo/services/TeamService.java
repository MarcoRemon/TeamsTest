package com.example.demo.services;

import com.example.demo.models.Team;
import com.example.demo.repositories.TeamRepository;
import com.example.demo.services.exceptions.InvalidRequestException;
import com.example.demo.services.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        return teamOptional.orElseThrow(() -> new NotFoundException("Team no encontrado"));
    }

    public List<Team> getTeamsByName(String nombre) {
        return teamRepository.getTeamsByName(nombre);
    }

    @Transactional
    public void createTeam(Team team) {

        if (checkTeam(team)) {
            teamRepository.save(team);
        } else {
            throw new InvalidRequestException("La solicitud es invalida");
        }
    }

    private Boolean checkTeam(Team team) {
        return (team.getId() != null &&
                team.getLiga() != null &&
                team.getPais() != null &&
                team.getNombre() != null);
    }


    @Transactional
    public void updateTeam(Long id, Team team) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            Team existingTeam = teamOptional.get();
            if (team.getNombre() != null && !team.getNombre().isEmpty()) {
                existingTeam.setNombre(team.getNombre());
            }
            if (team.getPais() != null && !team.getPais().isEmpty()) {
                existingTeam.setPais(team.getPais());
            }
            if (team.getLiga() != null && !team.getLiga().isEmpty()) {
                existingTeam.setLiga(team.getLiga());
            }
            teamRepository.save(existingTeam);
        } else {
            throw new NotFoundException("Equipo no encontrado");
        }
    }

    @Transactional
    public void deleteTeam(Long id) {

        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            teamRepository.deleteById(id);
        } else {
            throw new NotFoundException("Equipo no encontrado");

        }
    }

}
