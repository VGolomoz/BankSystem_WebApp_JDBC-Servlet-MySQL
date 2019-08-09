package project.DAO.interfaces;

import project.model.entities.OpCreditProof;

import java.util.List;

public interface OpCreditProofDAO extends DAO<OpCreditProof> {

    List<OpCreditProof> getAllById(int id);

}
