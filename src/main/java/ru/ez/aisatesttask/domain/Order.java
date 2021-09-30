package ru.ez.aisatesttask.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "order")
@Data
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User client;

    @NotBlank(message = "order type cannot be empty")
    private String orderType;

    @NotBlank(message = "date cannot be empty")
    private String date;

    @NotBlank(message = "time cannot be empty")
    private String time;



}
