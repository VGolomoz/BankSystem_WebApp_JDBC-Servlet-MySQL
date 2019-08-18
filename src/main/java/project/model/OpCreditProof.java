package project.model;


import java.util.Objects;

public class OpCreditProof extends Operation {

    private Integer managerId;
    private String decision;
    private String reason;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpCreditProof)) return false;
        if (!super.equals(o)) return false;
        OpCreditProof that = (OpCreditProof) o;
        return Objects.equals(managerId, that.managerId) &&
                Objects.equals(decision, that.decision) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), managerId, decision, reason);
    }

    @Override
    public String toString() {
        return "OpCreditProof{" +
                "managerId=" + managerId +
                ", decision=" + decision +
                ", reason='" + reason + '\'' +
                ", userId=" + userId +
                ", operationDate=" + operationDate +
                '}';
    }
}
