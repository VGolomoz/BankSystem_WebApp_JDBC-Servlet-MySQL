package project.model;


import java.util.Objects;

public class OpCreditProof extends Operation {

    private Integer managerId;
    private Boolean decision;

    public OpCreditProof() {
        this.managerId = null;
        this.decision = null;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Boolean getDecision() {
        return decision;
    }

    public void setDecision(Boolean decision) {
        this.decision = decision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpCreditProof)) return false;
        if (!super.equals(o)) return false;
        OpCreditProof that = (OpCreditProof) o;
        return Objects.equals(managerId, that.managerId) &&
                Objects.equals(decision, that.decision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), managerId, decision);
    }

    @Override
    public String toString() {
        return "OpCreditProof{" +
                "managerId=" + managerId +
                ", decision=" + decision +
                ", userId=" + userId +
                ", operationDate=" + operationDate +
                '}';
    }
}
