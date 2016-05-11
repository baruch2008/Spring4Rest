package com.tolfel.springrest.repositories;

import com.tolfel.springrest.entity.Tournament;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("tournamentRepository")
public class TournamentRepository extends AbstractDao<Integer, Tournament> implements TournamentDao {

    @PersistenceContext
    public EntityManager em;

    public Tournament findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        Tournament tournament = (Tournament)crit.uniqueResult();
        if(tournament!=null){
            Hibernate.initialize(tournament.getStages());
        }
        return tournament;
    }

    @SuppressWarnings("unchecked")
    public List<Tournament> findAllTournaments() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Tournament> tournaments = (List<Tournament>) criteria.list();
        return tournaments;
    }

    public List<Tournament> findAllActualTournaments() {
        Query results;
        results = em.createNamedQuery("findAllActualTournaments");
        List<Tournament> tournaments = results.getResultList();
        return tournaments;
    }
}
