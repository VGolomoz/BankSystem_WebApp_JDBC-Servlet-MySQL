package project.DAO.interfaces;

import project.model.OpTransfer;

import java.util.List;

public interface OpTransferDAO extends DAO<OpTransfer> {

    public List<OpTransfer> getAllById(int id);
}
