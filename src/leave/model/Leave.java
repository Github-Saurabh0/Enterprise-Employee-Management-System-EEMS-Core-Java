package leave.model;

import java.time.LocalDate;

public class Leave {

    private int leaveId;
    private int employeeId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // PENDING, APPROVED, REJECTED

    public Leave() {}

    public Leave(int leaveId, int employeeId, String leaveType, LocalDate startDate, LocalDate endDate, String status) {
        this.leaveId = leaveId;
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "leaveId=" + leaveId +
                ", employeeId=" + employeeId +
                ", leaveType='" + leaveType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                '}';
    }
}
