package com.example.communitysavings.rest;

import com.example.communitysavings.model.SavingsGroup;
import com.example.communitysavings.service.SavingsGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class SavingsGroupRestController {

    private final SavingsGroupService service;

    public SavingsGroupRestController(SavingsGroupService service) {
        this.service = service;
    }

    @GetMapping
    public List<SavingsGroup> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsGroup> getById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateGroupDto dto) {
        SavingsGroup g = new SavingsGroup(dto.getGroupName(), dto.getTargetAmount(), dto.getAdminMemberId());
        SavingsGroup saved = service.createGroup(g);
        return ResponseEntity.created(URI.create("/api/groups/" + saved.getId())).body(saved.getId());
    }
}
