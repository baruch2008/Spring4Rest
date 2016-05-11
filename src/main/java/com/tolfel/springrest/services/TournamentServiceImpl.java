package com.tolfel.springrest.services;

import com.tolfel.springrest.entity.Stage;
import com.tolfel.springrest.entity.Tournament;
import com.tolfel.springrest.repositories.TournamentDao;
import com.tolfel.springrest.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Service("tournamentService")
@Transactional
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentDao dao;

    public Tournament findByName(String name) {
        System.out.println("Finding Tournament with name " + name);
        Tournament tournament = dao.findByName(name);
        System.out.println("Tournament = " + tournament!=null?true:false);
        return tournament;
    }

    public List<Tournament> findAllTournaments(Boolean isActuall) {
        List<Tournament> tournaments;
        if(isActuall) {
            tournaments = dao.findAllActualTournaments();
        }
        else {
            tournaments = dao.findAllTournaments();
        }
        Iterator<Tournament> iterator = tournaments.listIterator();
        while(iterator.hasNext())
        {
            Tournament next = iterator.next();
            next.setStages(new HashSet<Stage>());
        }
        return tournaments;
    }
}
