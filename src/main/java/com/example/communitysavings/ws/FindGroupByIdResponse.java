package com.example.communitysavings.ws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "FindGroupByIdResponse", namespace = "http://example.com/communitysavings/ws")
public class FindGroupByIdResponse {

    @XmlElement(name = "savingsGroup")
    private SavingsGroupType savingsGroup;

    public SavingsGroupType getSavingsGroup() { return savingsGroup; }
    public void setSavingsGroup(SavingsGroupType savingsGroup) { this.savingsGroup = savingsGroup; }
}
