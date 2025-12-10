package com.example.communitysavings.ws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CreateGroupRequest", namespace = "http://example.com/communitysavings/ws")
public class CreateGroupRequest {

    @XmlElement(required = true)
    private String groupName;

    @XmlElement(required = true)
    private BigDecimal targetAmount;

    @XmlElement(required = true)
    private String adminMemberId;

    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }

    public BigDecimal getTargetAmount() { return targetAmount; }
    public void setTargetAmount(BigDecimal targetAmount) { this.targetAmount = targetAmount; }

    public String getAdminMemberId() { return adminMemberId; }
    public void setAdminMemberId(String adminMemberId) { this.adminMemberId = adminMemberId; }
}
