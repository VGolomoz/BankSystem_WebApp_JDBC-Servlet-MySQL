package project.DAO.interfaces;

import project.model.entities.OpTransfer;

import java.util.List;

public interface OpTransferDAO extends DAO<OpTransfer> {

    public List<OpTransfer> getAllById(int id);
}
