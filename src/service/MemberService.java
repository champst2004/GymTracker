package service;

import dao.MemberDAO;
import model.Member;

import java.util.List;

public class MemberService {
    private MemberDAO memberDAO;

    public MemberService() {
        this.memberDAO = new MemberDAO();
    }

    public boolean addMember(Member m) {
        if (m.getPhone() != null && m.getPhone().length() == 10) {
            return memberDAO.addMember(m);
        }
        return false;
    }

    public List<Member> getAllMembers() {
        return memberDAO.getAllMembers();
    }

    public Member getMemberById(int id) {
        return memberDAO.getMemberById(id);
    }

    public boolean updateMember(Member m) {
        if (m.getPhone() != null && m.getPhone().length() == 10) {
            return memberDAO.updateMember(m);
        }
        return false;
    }

    public boolean deleteMember(int id) {
        return memberDAO.deleteMember(id);
    }

    public boolean assignTrainer(int memberId, int trainerId) {
        return memberDAO.assignTrainer(memberId, trainerId);
    }

    public boolean removeTrainer(int memberId) {
        return memberDAO.removeTrainer(memberId);
    }
}
