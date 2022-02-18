package com.eteration.controller;

public class TransactionStat {
	public final static String status = "OK";

    public String approvalCode;

    public String getStatus() {
        return status;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
}
