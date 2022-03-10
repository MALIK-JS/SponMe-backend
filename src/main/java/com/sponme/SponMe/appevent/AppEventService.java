package com.sponme.SponMe.appevent;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AppEventService {
    private EventDAO eventDAO;


    @Transactional
    public List<AppEvent> findAll() {
        return eventDAO.findAll();
    }


    @Transactional
    public AppEvent findById(int theId) {
        return eventDAO.findById(theId);
    }

    @Transactional
    public void save(AppEvent theEvent) {
        eventDAO.save(theEvent);
    }

    @Transactional
    public void deleteById(int theId) {
        eventDAO.deleteById(theId);
    }
}
