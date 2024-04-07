package com.example.demo.controllers;

import com.example.demo.models.Team;
import com.example.demo.services.TeamService;
import com.example.demo.services.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
@Tag(name = "Teams")
@SecurityRequirement(name = "Bearer Authentication")
public class TeamController {

    private final TeamService teamService;

    private final Logger LOGGER = LoggerFactory.getLogger(TeamController.class);

    private final String UNEXPECTED_ERROR = "Unexpected Exception occurred";

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping(value = "")
    @Operation(summary = "Retrieve all teams")
    public ResponseEntity<List<Team>> getAllTeams() {
        try {

            List<Team> teamList = teamService.getAllTeams();

            return new ResponseEntity<>(teamList, HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.info(UNEXPECTED_ERROR, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get a singular team by id")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") Long id) {
        try {

            Team team = teamService.getTeamById(id);

            return ResponseEntity.ok(team);

        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.info(UNEXPECTED_ERROR, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/buscar")
    @Operation(summary = "Get team list by name coincidences")
    public ResponseEntity<List<Team>> getTeamByName(@RequestParam("nombre") String nombre) {
        try {

            List<Team> teams = teamService.getTeamsByName(nombre);

            return new ResponseEntity<>(teams, HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.info(UNEXPECTED_ERROR, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "")
    @Operation(summary = "Create a team")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        try {

            teamService.createTeam(team);

            return new ResponseEntity<>(team, HttpStatus.CREATED);

        } catch (Exception e) {
            LOGGER.info(UNEXPECTED_ERROR, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update a team")
    public ResponseEntity<Team> updateTeam(@PathVariable("id") Long id, @RequestBody Team team) {
        try {

            teamService.updateTeam(id, team);

            return ResponseEntity.ok(team);

        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.info(UNEXPECTED_ERROR, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete a team")
    public ResponseEntity<Team> deleteTeam(@PathVariable("id") Long id) {
        try {

            teamService.deleteTeam(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.info(UNEXPECTED_ERROR, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
