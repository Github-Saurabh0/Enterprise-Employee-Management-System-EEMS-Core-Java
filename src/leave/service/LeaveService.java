package leave.service;

import leave.dao.LeaveDao;
import leave.model.Leave;

import java.util.List;

public class LeaveService {

    private final LeaveDao leaveDao;

    public LeaveService(LeaveDao leaveDao) {
        this.leaveDao = leaveDao;
    }

    public void applyLeave(Leave leave) {
        // TODO: Add validation in Day 5
        leaveDao.applyLeave(leave);
    }

    public List<Leave> getLeaves() {
        return leaveDao.getAllLeaves();
    }

    public void approveLeave(int leaveId) {
        // TODO: Workflow logic later
    }
}
