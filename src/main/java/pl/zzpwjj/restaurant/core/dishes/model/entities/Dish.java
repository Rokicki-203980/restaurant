package pl.zzpwjj.restaurant.core.dishes.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "dish")
public class Dish {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dish_type")
    private DishType dishType;

    @NotNull
    private Double price;

    @NotNull
    private String name;

    @NotNull
    private String description;


}