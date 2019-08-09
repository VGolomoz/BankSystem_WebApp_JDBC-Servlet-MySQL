package project.DAO.interfaces;

import project.model.entities.OpReplenishment;

import java.util.List;

public interface OpReplenishmentDAO extends DAO<OpReplenishment> {


    public List<OpReplenishment> getAllById(int id);

}
