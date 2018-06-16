package pl.zzpwjj.restaurant.core.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "dish_food_order")
public class DishFoodOrder {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_order")
    private FoodOrder food_order_id;

    @ManyToOne
    @JoinColumn(name = "dish")
    private Dish dish_id;

}