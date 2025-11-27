package leave.dao;

import leave.model.Leave;
import java.util.List;

public interface LeaveDao {

    void applyLeave(Leave leave);

    List<Leave> getAllLeaves();

    Leave getLeaveById(int leaveId);

    void updateLeave(Leave leave);

    void deleteLeave(int leaveId);
}
