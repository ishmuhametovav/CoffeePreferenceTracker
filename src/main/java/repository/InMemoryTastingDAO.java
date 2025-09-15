package repository;

import model.Tasting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class InMemoryTastingDAO
{
    private List<Tasting> tastings = new ArrayList<>();
    private AtomicInteger genId = new AtomicInteger(0);

    public Tasting createTasting(int userId, int coffeeId, Tasting.GRADE grade, String description)
    {
        Tasting tasting = new Tasting(genId.incrementAndGet(), userId, coffeeId, grade, description);
        tastings.add(tasting);
        return tasting;
    }
    public List<Tasting> findTastingByUserId(int userId)
    {
        List<Tasting> userTasting = new ArrayList<>();
        for(Tasting t : tastings)
        {
            if(t.getUserId() == userId) userTasting.add(t);
        }
        return userTasting;
    }
    public List<Tasting> findTastingByCoffeeId(int coffeeId)
    {
        List<Tasting> coffeeTasting = new ArrayList<>();
        for(Tasting t : tastings)
        {
            if(t.getCoffeeId() == coffeeId) coffeeTasting.add(t);
        }
        return coffeeTasting;
    }
    public Tasting findTastingById(int id)
    {
        return tastings.stream().filter(element->element.getUserId() == id)
                .findFirst()
                .orElse(null);
    }
    public void updateTasting(Tasting tasting)
    {
        int tastingIndex = IntStream.range(0, tastings.size())
                .filter(element->tastings.get(element).getId() == tasting.getId())
                .findFirst().orElse(-1);
        tastings.set(tastingIndex, tasting);
    }
    public void deleteTasting(int id)
    {
        Tasting tasting = findTastingById(id);
        tastings.remove(tasting);
    }
}
