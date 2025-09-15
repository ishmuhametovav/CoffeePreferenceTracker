package service;

import model.Coffee;

import java.util.List;

public interface CoffeeService
{
    Coffee createCoffee(String name, String origin, String variety, Coffee.Processing processing, Coffee.Roast roastLevel);
    List<Coffee> getAllCoffees();
    Coffee findCoffeeById(int id) throws IllegalArgumentException;
    void updateCoffee(Coffee coffee);
    void deleteCoffee(int id);
}
