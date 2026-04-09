package service;

import model.Attendance;
import java.util.List;

/**
 * @author GymTracker
 * @version 1.0
 */
public interface IAttendanceService {
    /**
     * @param a Attendance object
     * @return boolean
     */
    boolean markAttendance(Attendance a);

    /**
     * @param memberId Member ID
     * @return list
     */
    List<Attendance> getAttendanceByMember(int memberId);

    /**
     * @return list
     */
    List<Attendance> getAllAttendance();
}
