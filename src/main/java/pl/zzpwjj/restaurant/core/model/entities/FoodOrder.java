package pl.zzpwjj.restaurant.core.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "food_order")
public class FoodOrder {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "personal_data")
    private PersonalData personal_data_id;

    @OneToOne
    @JoinColumn(name = "address")
    private Address address_id;

    @NotNull
    private Double full_price;

    @NotNull
    private Date date_of_order;

    private Date date_of_realization;

}