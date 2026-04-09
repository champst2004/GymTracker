package service;

import dao.AttendanceDAO;
import model.Attendance;

import java.util.List;

/**
 * @author GymTracker
 * @version 1.0
 */
public class AttendanceServiceImpl implements IAttendanceService {

    private AttendanceDAO attendanceDAO;

    public AttendanceServiceImpl() {
        this.attendanceDAO = new AttendanceDAO();
    }

    @Override
    public boolean markAttendance(Attendance a) {
        return attendanceDAO.markAttendance(a);
    }

    @Override
    public List<Attendance> getAttendanceByMember(int memberId) {
        return attendanceDAO.getAttendanceByMember(memberId);
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceDAO.getAllAttendance();
    }
}
