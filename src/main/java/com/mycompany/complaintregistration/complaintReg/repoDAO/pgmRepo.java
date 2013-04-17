package com.mycompany.complaintregistration.complaintReg.repoDAO;

import com.mycompany.complaintregistration.complaintReg.ProgrammerAnalystDetail;
import java.util.List;

/**
 *
 * @author Sintu Pal
 */
public interface pgmRepo {

    ProgrammerAnalystDetail read(String Pgmname);

    void save(ProgrammerAnalystDetail detail, boolean add);

    List<ProgrammerAnalystDetail> getAllDetails();
}
