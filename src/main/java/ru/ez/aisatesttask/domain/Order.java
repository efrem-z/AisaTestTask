package ru.ez.aisatesttask.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "order type cannot be empty")
    private String orderType;

    @OneToOne
    @NotBlank
    private User client;

    @OneToOne
    @NotBlank
    private ReservationTime reservationTime;



}
