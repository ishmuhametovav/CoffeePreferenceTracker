package service.impl;

import model.Tasting;
import repository.InMemoryTastingDAO;
import service.TastingService;

import java.util.List;

public class InMemoryTastingServiceImpl implements TastingService
{
    private InMemoryTastingDAO tastingDAO =  new InMemoryTastingDAO();

    @Override
    public Tasting createTasting(int userId, int coffeeId, Tasting.GRADE grade, String review)
    {
        return tastingDAO.createTasting(userId, coffeeId, grade, review);
    }
    @Override
    public Tasting findTastingById(int id) throws IllegalArgumentException
    {
        return tastingDAO.findTastingById(id);
    }
    @Override
    public List<Tasting> findTastingByUserId(int userId) throws IllegalArgumentException
    {
        return tastingDAO.findTastingByUserId(userId);
    }
    @Override
    public List<Tasting> findTastingByCoffeeId(int coffeeId) throws IllegalArgumentException
    {
        return tastingDAO.findTastingByCoffeeId(coffeeId);
    }
    @Override
    public void updateTasting(Tasting tasting)
    {
        tastingDAO.updateTasting(tasting);
    }
    @Override
    public void deleteTasting(int id)
    {
        tastingDAO.deleteTasting(id);
    }
}
