package project.DAO.interfaces;

import project.model.OpCreditProof;

import java.util.List;

public interface OpCreditProofDAO extends DAO<OpCreditProof> {

    List<OpCreditProof> getAllById(int id);

}
