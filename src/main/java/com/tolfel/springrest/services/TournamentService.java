package com.tolfel.springrest.services;

import com.tolfel.springrest.entity.Tournament;

import java.util.List;


public interface TournamentService {

    Tournament findByName(String name);

    List<Tournament> findAllTournaments(Boolean isActuall);
}
