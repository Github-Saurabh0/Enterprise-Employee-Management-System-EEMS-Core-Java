package leave.dao;

import leave.model.Leave;

import java.util.List;

public class FileLeaveDaoImpl implements LeaveDao {

    private final String filePath;

    public FileLeaveDaoImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void applyLeave(Leave leave) {
        // TODO: Implement CSV file write
    }

    @Override
    public List<Leave> getAllLeaves() {
        // TODO: Implement CSV read logic
        return List.of();
    }

    @Override
    public Leave getLeaveById(int leaveId) {
        // TODO: Implement find by ID
        return null;
    }

    @Override
    public void updateLeave(Leave leave) {
        // TODO: Implement update logic
    }

    @Override
    public void deleteLeave(int leaveId) {
        // TODO: Implement delete logic
    }
}
