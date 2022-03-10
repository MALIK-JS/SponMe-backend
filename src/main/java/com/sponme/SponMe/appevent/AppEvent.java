package com.sponme.SponMe.appevent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="app_event")
public class AppEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="event_date")
    private String event_date;
    @Column(name="location")
    private String location;
    @Column(name="users_id")
    private Long users_id;
    @Column(name="cuisine")
    private String cuisine;
    @Column(name="description")
    private String description;

    public AppEvent(String title, String event_date, String location) {
        this.title = title;
        this.event_date = event_date;
        this.location = location;
    }
}
