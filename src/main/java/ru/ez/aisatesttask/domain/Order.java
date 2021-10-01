package ru.ez.aisatesttask.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

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

    @NotBlank(message = "service type cannot be empty")
    private String serviceType;

    @NotBlank(message = "date cannot be empty")
    private Date date;


    public Order(){
    }

    public Order(User client, String serviceType, Date date) {
        this.client = client;
        this.serviceType = serviceType;
        this.date = date;
    }
}
