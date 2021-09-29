package ru.ez.aisatesttask.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "time")
@Data
public class ReservationTime {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date date;

}
