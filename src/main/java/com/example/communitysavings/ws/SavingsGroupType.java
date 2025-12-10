package com.example.communitysavings.ws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SavingsGroupType", propOrder = {"id", "groupName", "targetAmount", "adminMemberId", "memberIds"})
public class SavingsGroupType {

    protected String id;
    @XmlElement(required = true)
    protected String groupName;
    @XmlElement(required = true)
    protected BigDecimal targetAmount;
    @XmlElement(required = true)
    protected String adminMemberId;
    protected SavingsGroupType.MemberIds memberIds;

    public String getId() { return id; }
    public void setId(String value) { this.id = value; }

    public String getGroupName() { return groupName; }
    public void setGroupName(String value) { this.groupName = value; }

    public BigDecimal getTargetAmount() { return targetAmount; }
    public void setTargetAmount(BigDecimal value) { this.targetAmount = value; }

    public String getAdminMemberId() { return adminMemberId; }
    public void setAdminMemberId(String value) { this.adminMemberId = value; }

    public SavingsGroupType.MemberIds getMemberIds() { return memberIds; }
    public void setMemberIds(SavingsGroupType.MemberIds value) { this.memberIds = value; }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class MemberIds {
        @XmlElement(name = "memberId")
        protected List<String> memberId;

        public List<String> getMemberId() {
            if (memberId == null) {
                memberId = new ArrayList<>();
            }
            return this.memberId;
        }
    }
}
