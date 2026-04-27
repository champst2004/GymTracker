package service;

import model.Attendance;
import java.util.List;

public interface IAttendanceService {
    boolean markAttendance(Attendance a);
    List<Attendance> getAttendanceByMember(int memberId);
    List<Attendance> getAllAttendance();
}
