package model;

public class Attendance {
    private int attendanceId;
    private int memberId;
    private String memberName;
    private String checkInTime;

    public Attendance() {}

    public Attendance(int attendanceId, int memberId, String memberName, String checkInTime) {
        this.attendanceId = attendanceId;
        this.memberId = memberId;
        this.memberName = memberName;
        this.checkInTime = checkInTime;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

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
