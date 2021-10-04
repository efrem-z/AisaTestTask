package ru.ez.aisatesttask.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@EqualsAndHashCode

public class Order  {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "service type cannot be empty")
    private String serviceType;
    
    private Date date;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User client;

    public Order(){
    }

    public Order(User client, String serviceType, Date date) {
        this.client = client;
        this.serviceType = serviceType;
        this.date = date;
    }
}
