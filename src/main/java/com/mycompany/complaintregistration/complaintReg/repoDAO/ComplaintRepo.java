package com.mycompany.complaintregistration.complaintReg.repoDAO;

import com.mycompany.complaintregistration.complaintReg.Complaint;
import java.util.List;

/**
 *
 * @author Samim
 */
public interface ComplaintRepo {

    Complaint read(int complaintNo);

    void save(Complaint complaintSave);

    List<Complaint> getAllComplaint();

    int complaintCount();

    void statusUpdate(Complaint com);

    void assingUpdate(Complaint com);

    public List<Complaint> getAllComplaintAgainstProgrammer(int pId);

    List<Complaint> getAllComplaintPending(String type);



    List<Complaint> statusPendingUnsolvedProgToUser(int complaintUserId);

    List<Complaint> statusSolvedProgToUser(int complaintUserId);

    void feedbackUpdate(Complaint com);

    void complaintSolveDate(Complaint com);
}