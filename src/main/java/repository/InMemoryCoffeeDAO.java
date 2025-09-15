package repository;

import model.Coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class InMemoryCoffeeDAO
{
    private AtomicInteger genId = new AtomicInteger(0);
    private List<Coffee> coffees = new ArrayList<>();

    public Coffee createCoffee(String name, String origin, String variety, Coffee.Processing processing, Coffee.Roast roastLevel)
    {
        Coffee coffee = new Coffee(genId.incrementAndGet(), name, origin, variety, processing, roastLevel);
        coffees.add(coffee);
        return coffee;
    }
    public List<Coffee> getAllCoffees()
    {
        return coffees;
    }
    public Coffee findCoffeeById(int id)
    {
        return coffees.stream().filter(element->element.getId() == id).findFirst().orElse(null);
    }
    public void updateCoffee(Coffee coffee)
    {
        int coffeeIndex = IntStream.range(0, coffees.size())
                .filter(index->coffees.get(index).getId() == coffee.getId())
                .findFirst().orElse(-1);

        if(coffeeIndex != -1) coffees.set(coffeeIndex, coffee);
    }
    public void deleteCoffee(int id)
    {
        Coffee coffee = findCoffeeById(id);
        if(coffee != null) coffees.remove(coffee);
    }
}
