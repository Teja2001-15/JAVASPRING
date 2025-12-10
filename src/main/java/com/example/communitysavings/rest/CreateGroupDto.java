package com.example.communitysavings.rest;

import java.math.BigDecimal;

public class CreateGroupDto {
    private String groupName;
    private BigDecimal targetAmount;
    private String adminMemberId;

    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }

    public BigDecimal getTargetAmount() { return targetAmount; }
    public void setTargetAmount(BigDecimal targetAmount) { this.targetAmount = targetAmount; }

    public String getAdminMemberId() { return adminMemberId; }
    public void setAdminMemberId(String adminMemberId) { this.adminMemberId = adminMemberId; }
}
