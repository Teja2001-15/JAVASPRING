package com.example.communitysavings.endpoint;

import com.example.communitysavings.config.WebServiceConfig;
import com.example.communitysavings.model.SavingsGroup;
import com.example.communitysavings.service.SavingsGroupService;
import com.example.communitysavings.ws.CreateGroupRequest;
import com.example.communitysavings.ws.CreateGroupResponse;
import com.example.communitysavings.ws.FindGroupByIdRequest;
import com.example.communitysavings.ws.FindGroupByIdResponse;
import com.example.communitysavings.ws.SavingsGroupType;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class SavingsGroupEndpoint {

    private final SavingsGroupService service;

    public SavingsGroupEndpoint(SavingsGroupService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE, localPart = "CreateGroupRequest")
    @ResponsePayload
    public CreateGroupResponse createGroup(@RequestPayload CreateGroupRequest request) {
        SavingsGroup group = new SavingsGroup(request.getGroupName(), request.getTargetAmount(), request.getAdminMemberId());
        SavingsGroup saved = service.createGroup(group);
        CreateGroupResponse resp = new CreateGroupResponse();
        resp.setGroupId(saved.getId());
        return resp;
    }

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE, localPart = "FindGroupByIdRequest")
    @ResponsePayload
    public FindGroupByIdResponse findGroupById(@RequestPayload FindGroupByIdRequest request) {
        Optional<SavingsGroup> opt = service.findById(request.getGroupId());
        FindGroupByIdResponse resp = new FindGroupByIdResponse();
        if (opt.isPresent()) {
            SavingsGroup s = opt.get();
            SavingsGroupType t = new SavingsGroupType();
            t.setId(s.getId());
            t.setGroupName(s.getGroupName());
            t.setTargetAmount(s.getTargetAmount());
            t.setAdminMemberId(s.getAdminMemberId());
            SavingsGroupType.MemberIds ids = new SavingsGroupType.MemberIds();
            if (s.getMemberIds() != null) {
                ids.getMemberId().addAll(s.getMemberIds());
            }
            t.setMemberIds(ids);
            resp.setSavingsGroup(t);
        }
        return resp;
    }
}
