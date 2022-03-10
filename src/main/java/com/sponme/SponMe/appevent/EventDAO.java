package com.sponme.SponMe.appevent;

import com.sponme.SponMe.appuser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@AllArgsConstructor
public class EventDAO {

    private EntityManager entityManager;

    public List<AppEvent> findAll() {
        // create a query
        Query theQuery =
                entityManager.createQuery("from AppEvent");

        // execute query and get result list
        List<AppEvent> events = theQuery.getResultList();

        // return the results

        return events;
    }

    public AppEvent findById(int theId) {

        // get employee
        AppEvent theEvent =
                entityManager.find(AppEvent.class, theId);

        // return employee
        return theEvent;
    }

    public void save(AppEvent event) {
        // save or update the event
        AppEvent theEvent = entityManager.merge(event);
        // update with id from db ... so we can get generated id for save/insert
        event.setId(theEvent.getId());
    }

    public void deleteById(int theId) {

        // delete object with primary key
        Query theQuery = entityManager.createQuery(
                "delete from AppEvent where id=:eventId");

        theQuery.setParameter("eventId", theId);
        theQuery.executeUpdate();
    }

}
