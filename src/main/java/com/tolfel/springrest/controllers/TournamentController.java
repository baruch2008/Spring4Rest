package com.tolfel.springrest.controllers;

import com.tolfel.springrest.entity.Tournament;
import com.tolfel.springrest.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TournamentController {
    @Autowired
    TournamentService tournamentService;

    @RequestMapping(value = "/tournaments/is_actuall={is_actuall}", method = RequestMethod.GET)
    public ResponseEntity<List<Tournament>> listUsers(@PathVariable("is_actuall") Boolean isActuall) {
        if(!(isActuall instanceof Boolean)) {
            System.out.println("isActuall has not Boolean type");
            return new ResponseEntity<List<Tournament>>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("Fetching tournaments with isActuall = " + isActuall);
        List<Tournament> tournaments = tournamentService.findAllTournaments(isActuall);
        if(tournaments.isEmpty()){
            return new ResponseEntity<List<Tournament>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Tournament>>(tournaments, HttpStatus.OK);
    }

    @RequestMapping(value = "/tournament/name={name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tournament> getUserByLogin(@PathVariable("name") String name) {
        System.out.println("Fetching Tournament with name " + name);
        Tournament tournament = tournamentService.findByName(name);
        if (tournament == null) {
            System.out.println("Tournament with name " + name + " not found");
            return new ResponseEntity<Tournament>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Tournament>(tournament, HttpStatus.OK);
    }
}
