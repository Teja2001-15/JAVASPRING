package com.example.communitysavings.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "savings_groups")
public class SavingsGroup {

    @Id
    private String id;
    private String groupName;
    private BigDecimal targetAmount;
    private String adminMemberId;
    private List<String> memberIds = new ArrayList<>();

    public SavingsGroup() {}

    public SavingsGroup(String groupName, BigDecimal targetAmount, String adminMemberId) {
        this.groupName = groupName;
        this.targetAmount = targetAmount;
        this.adminMemberId = adminMemberId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }

    public BigDecimal getTargetAmount() { return targetAmount; }
    public void setTargetAmount(BigDecimal targetAmount) { this.targetAmount = targetAmount; }

    public String getAdminMemberId() { return adminMemberId; }
    public void setAdminMemberId(String adminMemberId) { this.adminMemberId = adminMemberId; }

    public List<String> getMemberIds() { return memberIds; }
    public void setMemberIds(List<String> memberIds) { this.memberIds = memberIds; }
}
