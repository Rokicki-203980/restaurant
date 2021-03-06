package pl.zzpwjj.restaurant.core.foodOrders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.zzpwjj.restaurant.common.exceptions.InvalidParametersException;
import pl.zzpwjj.restaurant.common.exceptions.ItemNotFoundException;
import pl.zzpwjj.restaurant.core.foodOrders.model.dto.DishFoodOrderDto;
import pl.zzpwjj.restaurant.core.foodOrders.model.entities.DishFoodOrder;
import pl.zzpwjj.restaurant.core.foodOrders.model.input.AddDishFoodOrderInput;
import pl.zzpwjj.restaurant.core.foodOrders.repositories.DishFoodOrderRepository;

import java.util.List;

@Service
public class DishFoodOrdersService {
    private DishFoodOrderRepository dishFoodOrderRepository;

    @Autowired
    public DishFoodOrdersService(final DishFoodOrderRepository dishFoodOrderRepository) {
        this.dishFoodOrderRepository = dishFoodOrderRepository;
    }

    public List<DishFoodOrder> getDishFoodOrders() {
        return dishFoodOrderRepository.findAll();
    }

    public DishFoodOrder getDishFoodOrder(final Long id) throws ItemNotFoundException {
        return dishFoodOrderRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    public DishFoodOrder addDishFoodOrder(final AddDishFoodOrderInput addDishFoodOrderInput) {
        DishFoodOrder dishFoodOrder = new DishFoodOrder();
        dishFoodOrder.setFoodOrder(addDishFoodOrderInput.getFoodOrder());
        dishFoodOrder.setDish(addDishFoodOrderInput.getDish());
        return dishFoodOrderRepository.save(dishFoodOrder);
    }

    public void deleteDishFoodOrder(final Long id) throws ItemNotFoundException {
        try {
            dishFoodOrderRepository.deleteAllById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNotFoundException("DishFoodOrder with id = " + id + " does not exist", e);
        }
    }

    public void deleteDishFoodOrdersByFoodOrderId(final Long id) throws ItemNotFoundException {
        try {
            dishFoodOrderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNotFoundException("DishFoodOrder with id = " + id + " does not exist", e);
        }
    }


    public void editDishFoodOrder(final DishFoodOrderDto dishFoodOrderDto) throws InvalidParametersException {
        if (!dishFoodOrderRepository.existsById(dishFoodOrderDto.getId())) {
            throw new InvalidParametersException("DishFoodOrder with id = " + dishFoodOrderDto.getId() + " does not exist");
        }

        DishFoodOrder dishFoodOrder = new DishFoodOrder();
        dishFoodOrder.setId(dishFoodOrderDto.getId());
        dishFoodOrder.setFoodOrder(dishFoodOrderDto.getFoodOrder());
        dishFoodOrder.setDish(dishFoodOrderDto.getDish());

        dishFoodOrderRepository.save(dishFoodOrder);
    }

    public List<Long> getMostOrderedDishId(){
        return dishFoodOrderRepository.findMostOrderedDishId();
    }
}
