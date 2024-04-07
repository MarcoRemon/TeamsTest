package com.example.demo;

import com.example.demo.models.Team;
import com.example.demo.repositories.TeamRepository;
import com.example.demo.services.TeamService;
import com.example.demo.services.exceptions.InvalidRequestException;
import com.example.demo.services.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TeamServiceTests {

    private TeamRepository teamRepository;
    private TeamService teamService;

    @BeforeEach
    void setup() {
        teamRepository = Mockito.mock(TeamRepository.class);
        teamService = new TeamService(teamRepository);
    }

    @Test
    void getTeamByIdExceptionTest() {
        when(teamRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> teamService.getTeamById(1L));

    }

    @Test
    void createValidTeamTest() {
        Team team = getValidTeam();

        teamService.createTeam(team);

        verify(teamRepository, times(1)).save(any());
    }

    @Test
    void createTeamFailure() {
        Team team = new Team();

        assertThrows(InvalidRequestException.class, () -> teamService.createTeam(team));

    }

    @Test
    void updateTeam() {
        Team team = getValidTeam();
        when(teamRepository.findById(any())).thenReturn(Optional.of(team));

        teamService.updateTeam(1L, team);

        verify(teamRepository, times(1)).save(any());

    }

    @Test
    void updateTeamFailure() {
        Team team = new Team();
        when(teamRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class,()->teamService.updateTeam(1L,team));
    }

    @Test
    void deleteTeamFailure(){
        when(teamRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class,()->teamService.deleteTeam(1L));
    }

    @Test
    void deleteTeam(){
        Team team = getValidTeam();
        when(teamRepository.findById(any())).thenReturn(Optional.of(team));
        teamService.deleteTeam(1L);
        verify(teamRepository,times(1)).deleteById(any());
    }




    private Team getValidTeam() {
        Team validTeam = new Team();
        validTeam.setLiga("TEST LEAGUE");
        validTeam.setNombre("TEST NAME");
        validTeam.setPais("TEST COUNTRY");
        validTeam.setId(999L);
        return validTeam;
    }


}
