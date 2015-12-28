package com.mycompany.ssms.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * All Roles as off RoleMaster Table. By its id only Document Movement will work
 *
 * @author ratul
 */
public class RoleMapping {

    public static final Map<Integer, String> roleIds = new HashMap<>();
    public static final int GENERAL = 0;
    public static final int COORDINATOR = 1;
    public static final int TECHNICAL_PREPARATION = 2;
    public static final int COMMERCIAL_PREPARATION = 3;
    public static final int QR_PREPARATION = 4;
    public static final int TECHNICAL_APPROVAL = 5;
    public static final int COMMERCIAL_APPROVAL = 6;
    public static final int QR_APPROVAL = 7;
    public static final int PACKAGE_INDENTOR = 8;

    public static final int CONTRACTSEVAL = 11;
    public static final int TECHNICALEVAL = 12;
    public static final int FINANCEEVAL = 13;
    public static final int TECHCOMMDEVIATION = 14;
    public static final int TC_MEETING_QR = 15;
    public static final int TC_MEETING_QR_SHORTLISTING = 16;
    public static final int TC_MEETING_TECHNICAL = 17;
    public static final int TC_MEETING_TECHNICAL_SHORTLISTING = 18;
    public static final int TC_MEETING_PRICE = 19;
    public static final int TC_MEETING_PRICE_SHORTLISTING = 20;
    public static final int QR_BR = 21;
    public static final int TECH_BR = 22;
    public static final int PRICE_BR = 23;
    public static final int LOA = 24;
    public static final int TECHNICAL_FORMS_EVAL = 25;
    public static final int TECH_COMM_DEVIATION_WORKFLOW = 26;
    public static final int COMMERCIAL_FORMS_EVAL = 27;
    public static final int DRAWING_SCRUTINY = 28;
    public static final int BID_DATE_EVALUATION = 29;
    public static final int BID_GUA_APPROVE_WRKFLW = 30;
    public static final int TENDER_REQ_APPROVAL = 31;
    public static final int CORRIGENDUM = 32;
    public static final int QR_STATEMENT_APPROVAL = 33;
    public static final int TECHNICAL_FORMS_EVAL_WORKFLOW = 34;
    public static final int COMMERCIAL_FORMS_EVAL_WORKFLOW = 35;
    public static final int PRICE_IMPLICATION = 36;
    public static final int PRICE_NEGOTIATION = 37;
    public static final int NIB = 38;
    public static final int TC_MEMBER_APPROVAL = 39;
    public static final int PRE_BID = 40;

    public static final int INITIATOR = 100;
    public static final int INITIATOR_ADMIN = 101;

    static {
        roleIds.put(GENERAL, "General");
        roleIds.put(CONTRACTSEVAL, "Contracts");
        roleIds.put(TECHNICALEVAL, "Technical");
        roleIds.put(FINANCEEVAL, "Finance");
        roleIds.put(INITIATOR, "Initator");
        roleIds.put(INITIATOR_ADMIN, "Initiator [Admin]");
        roleIds.put(TECHCOMMDEVIATION, "Techno-Commercial Deviation");
        roleIds.put(TC_MEETING_QR, "TC Meeting for QR Shortlisting of Bidders");
        roleIds.put(TC_MEETING_QR_SHORTLISTING, "Approval for Shortlisting of Bidders on QR");
        roleIds.put(TC_MEETING_TECHNICAL, "TC Meeting for Techno Commercial Shortlisting of Bidders");
    }
}
