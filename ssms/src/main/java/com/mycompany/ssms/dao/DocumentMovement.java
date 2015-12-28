package com.mycompany.ssms.dao;

import org.springframework.stereotype.Service;

/**
 *
 * @author ratul
 */
//@Service
public class DocumentMovement {
//
//    @Autowired
//    RolesByPackageRepo rolesByPackageRepo;
//    @Autowired
//    UserMasterRepo userMasterRepo;
//    @Autowired
//    BoardResolutionService boardResolutionService;
//    @Autowired
//    BoardResolutionRepo boardResolutionRepo;
//    @Autowired
//    TcMeetingService tcMeetingService;
//    @Autowired
//    RoleMasterRepo roleMasterRepo;
//    @Autowired
//    LoaService loaService;
//    @Autowired
//    EvaluationService evaluationService;
//    @Autowired
//    QrStatementsRepo qrStatementsRepo;
//    @Autowired
//    FormRepo formRepo;
//    @Autowired
//    PriceNegotiationService pns;
//    @Autowired
//    ApproveProjectService approveService;
//    @Autowired
//    SpecificationService specService;
//    @Autowired
//    GenerateClarObject clarObject;
//    @Autowired
//    EvaluationWorkflowService evaluationWorkflowService;
//    @Autowired
//    PostTenderWS postTenderWS;
//    @Autowired
//    SendDataToEproc sendToEproc;
//    @Autowired
//    PreBidService preBidService;
//    @Autowired
//    TCMemberApprovalService tCMemberApprovalService;
//
//    private void getLog(int docId) {
////        Logger.getLogger(DocumentId.docIds.get(docId) + " Completed Succesfully");
//    }
//
//    public int getPaneledUserId(int roleId, String docKey, boolean forWrkFlow) {// forWrkFlow has been taken for further modification in future if needed... 
//        RolesByPackage rbp = rolesByPackageRepo.findByRoleIdAndPackCode(roleId, docKey);
//        if (rbp == null || rbp.getUserId() == 0) {
//            throw new CcmsException("No user has been assigned ");
//        }
//        return rbp.getUserId();
//    }
//
//    @Transactional
//    public void updateRoleDone(int roleId, String docKey) {
//        rolesByPackageRepo.setCompleted(docKey, roleId);
//    }
//
//    public void setMovementStatusAssinged(int roleId, String docKey) {
//        setMovementStatus(RolesByPackage.ASSINGED, roleId, docKey);
//    }
//
//    public void setMovementStatusProcessing(int roleId, String docKey) {
//        setMovementStatus(RolesByPackage.PROCESSING, roleId, docKey);
//    }
//
//    public void setMovementStatusCompleted(int roleId, String docKey) {
//        setMovementStatus(RolesByPackage.COMPLETED, roleId, docKey);
//    }
//
//    public void setMovementStatusCompletedByDocId(int docId, String docKey) {
//        setMovementStatus(RolesByPackage.COMPLETED, roleMasterRepo.findIdByDocId(docId), docKey);
//    }
//
//    public void setMovementStatusSkippedByDocId(int docId, String docKey) {
//        setMovementStatus(RolesByPackage.SKIPPED, roleMasterRepo.findIdByDocId(docId), docKey);
//    }
//
//    @Transactional
//    private void setMovementStatus(int setCurrStatus, int roleId, String docKey) {
//        rolesByPackageRepo.setCurrStatus(setCurrStatus, docKey, roleId);
//    }
//
//    public void docDynamicFlow(int curDocId, String docKey, Object object) {
//        switch (curDocId) {
//            case DocumentId.NIB:
//                NIB nib = (NIB) object;
//                tCMemberApprovalService.setTCMemberApproval(nib, getPaneledUserId(RoleMapping.TC_MEMBER_APPROVAL, docKey, true));
//                setMovementStatusAssinged(RoleMapping.TC_MEMBER_APPROVAL, docKey);
//                setMovementStatusCompleted(RoleMapping.NIB, docKey);
//                break;
//            case DocumentId.TECHNICALAPPROVE:
//            case DocumentId.COMMERCIALAPPROVE:
//            case DocumentId.QRAPPROVE:
//            case DocumentId.COMBINEDAPPROVE:
//                ApproveSpecifications approveSpecifications = (ApproveSpecifications) object;
//                approveService.generateNib(approveSpecifications);
//                setMovementStatusAssinged(RoleMapping.NIB, docKey);
//                setMovementStatusCompletedByDocId(curDocId, docKey);
//                break;
//            case DocumentId.TECHNICALPREP:
//            case DocumentId.COMMERCIALPREP:
//            case DocumentId.QR:
//                Specifications spec = (Specifications) object;
//                specService.finalizeSpecPreparation(spec.getFormId());
////                setMovementStatusAssinged(RoleMapping.TC_MEMBER_APPROVAL, docKey);
//                setMovementStatusCompletedByDocId(curDocId, docKey);
//                break;
//            case DocumentId.PREBID:
//                PreBid preBid = (PreBid) object;
//                if (preBidService.setCorrigendumOrPBidStatusAfterPreBid(preBid)) {
////                    updateRoleDone(curDocId, docKey);
//                    setMovementStatusAssinged(RoleMapping.CORRIGENDUM, docKey);
//                    setMovementStatusCompleted(RoleMapping.PRE_BID, docKey);
//                }
//                break;
//
//            case DocumentId.CORRIGENDUMDOC:
//                updateRoleDone(curDocId, docKey);
//                setMovementStatusCompleted(RoleMapping.CORRIGENDUM, docKey);
//                break;
//
//            case DocumentId.QRSTATEMENTS:
//                QrStatements qs = (QrStatements) object;
//                evaluationService.createClarObject(curDocId, docKey, qs);
//                setMovementStatusCompleted(RoleMapping.QR_STATEMENT_APPROVAL, docKey);
//                updateRoleDone(curDocId, docKey);
//                qs = null;
//                break;
//
//            case DocumentId.QRTC:
//                TCMeeting qrTc = (TCMeeting) object;
//                tcMeetingService.setTcApproveShortlisting(docKey, curDocId, getPaneledUserId(RoleMapping.TC_MEETING_QR_SHORTLISTING, docKey, true), DocumentId.QRTCAPPROVESHORTLIST, qrTc, userMasterRepo);
//                qrTc = null;
//                updateRoleDone(curDocId, docKey);
//                setMovementStatusAssinged(RoleMapping.TC_MEETING_QR_SHORTLISTING, docKey);
//                setMovementStatusCompleted(RoleMapping.TC_MEETING_QR, docKey);
//                break;
//
//            case DocumentId.QRTCAPPROVESHORTLIST:
//                TCApproveShortList qrShrt = (TCApproveShortList) object;
//                boardResolutionService.setBoardResulution(docKey, getPaneledUserId(RoleMapping.QR_BR, docKey, true), DocumentId.QRBOARDRESOLUTION, DocumentId.QRTC, qrShrt);
//                qrShrt = null;
//                updateRoleDone(curDocId, docKey);
//                setMovementStatusAssinged(RoleMapping.QR_BR, docKey);
//                setMovementStatusCompleted(RoleMapping.TC_MEETING_QR_SHORTLISTING, docKey);
//                break;
//
//            case DocumentId.QRBOARDRESOLUTION:
//                BoardResolution qrBr = (BoardResolution) object;
//                boardResolutionService.update4DeviationAfterQRBR(docKey, curDocId, qrBr);
//                qrBr = null;
//                setMovementStatusCompleted(RoleMapping.QR_BR, docKey);
//                updateRoleDone(curDocId, docKey);
//                break;
//            case DocumentId.TECHCOMMDEVIATION:
//
//                break;
//
//            case DocumentId.TECHCOMMDEVSTATEMENTS:
//                TechCommDevStatements tcds = (TechCommDevStatements) object;
//                if (tcds.isClarNeed()) {
//                    clarObject.createClarDTO4Jobs(tcds.getFormId(), DocumentId.TECHCOMMDEVIATION, null);
//                }
//                setMovementStatusCompleted(RoleMapping.TECH_COMM_DEVIATION_WORKFLOW, docKey);
//                evaluationWorkflowService.setClarRegister(tcds.getTenderNo());
////                updateRoleDone(curDocId, docKey);
////                setMovementStatusAssinged(RoleMapping.QR_BR, docKey);
//
//                break;
//
//            case DocumentId.COMMFORMSTATEMENTS:
//                OtherFormsStatements ofsCom = (OtherFormsStatements) object;
//                for (Long fid : ofsCom.getFrmEvald()) {
//                    clarObject.createObjectForSingleVendor(fid, ofsCom.getBidType());
//                }
//                evaluationWorkflowService.setClarRegister(ofsCom.getTenderNo());
//                setMovementStatusCompleted(RoleMapping.COMMERCIAL_FORMS_EVAL_WORKFLOW, docKey);
//                updateRoleDone(curDocId, docKey);
//                break;
//            case DocumentId.TECHFORMSTATEMENTS:
//                OtherFormsStatements ofs = (OtherFormsStatements) object;
//                for (Long fid : ofs.getFrmEvald()) {
//                    clarObject.createObjectForSingleVendor(fid, ofs.getBidType());
//                }
//                evaluationWorkflowService.setClarRegister(ofs.getTenderNo());
//                setMovementStatusCompleted(RoleMapping.TECHNICAL_FORMS_EVAL_WORKFLOW, docKey);
//                updateRoleDone(curDocId, docKey);
//                break;
//
//            case DocumentId.TECHNICALTC:
//                TCMeeting techTc = (TCMeeting) object;
//                tcMeetingService.setTcApproveShortlisting(docKey, curDocId, getPaneledUserId(RoleMapping.TC_MEETING_TECHNICAL_SHORTLISTING, docKey, true), DocumentId.TECHTCAPPROVESHORTLIST, techTc, userMasterRepo);
//                techTc = null;
//                updateRoleDone(curDocId, docKey);
//                setMovementStatusAssinged(RoleMapping.TC_MEETING_TECHNICAL_SHORTLISTING, docKey);
//                setMovementStatusCompleted(RoleMapping.TC_MEETING_TECHNICAL, docKey);
//                break;
//
//            case DocumentId.TECHTCAPPROVESHORTLIST:
//                TCApproveShortList techShrt = (TCApproveShortList) object;
//                boardResolutionService.setBoardResulution(docKey, getPaneledUserId(RoleMapping.TECH_BR, docKey, true), DocumentId.TECHCOMMBBOARDRESOLUTION, DocumentId.TECHNICALTC, techShrt);
//                updateRoleDone(curDocId, docKey);
//                setMovementStatusAssinged(RoleMapping.TECH_BR, docKey);
//                setMovementStatusCompleted(RoleMapping.TC_MEETING_TECHNICAL_SHORTLISTING, docKey);
//                break;
//
//            case DocumentId.TECHCOMMBBOARDRESOLUTION:
//                setMovementStatusCompleted(RoleMapping.TECH_BR, docKey);
//                break;
//
//            case DocumentId.PRICETC:
//                TCMeeting priceTc = (TCMeeting) object;
//                if (!priceTc.isNeedClarification()) {
//                    tcMeetingService.setTcApproveShortlisting(docKey, curDocId, getPaneledUserId(RoleMapping.TC_MEETING_PRICE_SHORTLISTING, docKey, true), DocumentId.PRICETCAPPROVESHORTLIST, priceTc, userMasterRepo);
//                    setMovementStatusAssinged(RoleMapping.TC_MEETING_PRICE_SHORTLISTING, docKey);
//                    setMovementStatusCompleted(RoleMapping.TC_MEETING_PRICE, docKey);
//                }
//                updateRoleDone(curDocId, docKey);
//                break;
//
//            case DocumentId.APPROVAL_NEGOTATION:
//                NegotiationsApproval na = (NegotiationsApproval) object;
//                pns.setNegotiation(na);
//                na = null;
//                setMovementStatusCompleted(RoleMapping.PRICE_NEGOTIATION, docKey);
//
//                updateRoleDone(curDocId, docKey);
//                break;
//
//            case DocumentId.PRICETCAPPROVESHORTLIST:
//                TCApproveShortList priceShrt = (TCApproveShortList) object;
//                boardResolutionService.setBoardResulution(docKey, getPaneledUserId(RoleMapping.PRICE_BR, docKey, true), DocumentId.PCBOARDRESOLUTION, DocumentId.PRICETC, priceShrt);
//                updateRoleDone(curDocId, docKey);
//                setMovementStatusAssinged(RoleMapping.PRICE_BR, docKey);
//                setMovementStatusCompleted(RoleMapping.TC_MEETING_PRICE_SHORTLISTING, docKey);
//                break;
//
//            case DocumentId.PCBOARDRESOLUTION:
//                BoardResolution pcBr = (BoardResolution) object;
//                loaService.setLoa(getPaneledUserId(RoleMapping.LOA, docKey, true), pcBr);
//                setMovementStatusAssinged(RoleMapping.LOA, docKey);
//                setMovementStatusCompleted(RoleMapping.PRICE_BR, docKey);
//                pcBr = null;
//                updateRoleDone(curDocId, docKey);
//                break;
//        }
//    }
}
