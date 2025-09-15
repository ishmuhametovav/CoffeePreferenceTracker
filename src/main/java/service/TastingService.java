package service;

import model.Coffee;
import model.Tasting;

import java.util.List;

public interface TastingService
{
    Tasting createTasting(int userId, int coffeeId, Tasting.GRADE grade, String review);
    Tasting findTastingById(int id) throws IllegalArgumentException;
    List<Tasting> findTastingByUserId(int userId) throws IllegalArgumentException;
    List<Tasting> findTastingByCoffeeId(int coffeeId) throws IllegalArgumentException;
    void updateTasting(Tasting tasting);
    void deleteTasting(int id);
}
