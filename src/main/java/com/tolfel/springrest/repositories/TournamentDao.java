package com.tolfel.springrest.repositories;

import com.tolfel.springrest.entity.Tournament;

import java.util.List;


public interface TournamentDao {

    Tournament findByName(String name);

    List<Tournament> findAllTournaments();

    List<Tournament> findAllActualTournaments();
}
