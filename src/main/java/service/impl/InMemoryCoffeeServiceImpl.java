package service.impl;

import model.Coffee;
import repository.InMemoryCoffeeDAO;
import service.CoffeeService;

import java.util.List;

public class InMemoryCoffeeServiceImpl implements CoffeeService
{
    InMemoryCoffeeDAO coffeeDAO = new InMemoryCoffeeDAO();
    @Override
    public Coffee createCoffee(String name, String origin, String variety, Coffee.Processing processing, Coffee.Roast roastLevel)
    {
        Coffee coffee = coffeeDAO.createCoffee(name, origin, variety, processing, roastLevel);
        return coffee;
    }
    @Override
    public List<Coffee> getAllCoffees()
    {
        return coffeeDAO.getAllCoffees();
    }
    @Override
    public Coffee findCoffeeById(int id) throws IllegalArgumentException
    {
        Coffee coffee = coffeeDAO.findCoffeeById(id);
        if(coffee == null) throw new IllegalArgumentException("Cannot find coffee with such id!");
        return coffee;
    }
    @Override
    public void updateCoffee(Coffee coffee)
    {
        coffeeDAO.updateCoffee(coffee);
    }
    @Override
    public void deleteCoffee(int id)
    {
        coffeeDAO.deleteCoffee(id);
    }
}
