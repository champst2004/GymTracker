package model;

/**
 * @author GymTracker
 * @version 1.0
 */
public class Attendance {
    private int attendanceId;
    private int memberId;
    private String memberName;
    private String checkInTime;

    /** Default constructor */
    public Attendance() {}

    /**
     * Parameterized constructor.
     * @param attendanceId The attendance ID
     * @param memberId The member ID
     * @param memberName The member name
     * @param checkInTime The check in time
     */
    public Attendance(int attendanceId, int memberId, String memberName, String checkInTime) {
        this.attendanceId = attendanceId;
        this.memberId = memberId;
        this.memberName = memberName;
        this.checkInTime = checkInTime;
    }

    /**
     * @return the attendanceId
     */
    public int getAttendanceId() {
        return attendanceId;
    }

    /**
     * @param attendanceId the attendanceId to set
     */
    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    /**
     * @return the memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * @param memberName the memberName to set
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * @return the checkInTime
     */
    public String getCheckInTime() {
        return checkInTime;
    }

    /**
     * @param checkInTime the checkInTime to set
     */
    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", checkInTime='" + checkInTime + '\'' +
                '}';
    }
}
