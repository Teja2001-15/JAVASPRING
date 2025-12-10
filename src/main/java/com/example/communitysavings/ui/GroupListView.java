package com.example.communitysavings.ui;

import com.example.communitysavings.model.SavingsGroup;
import com.example.communitysavings.service.SavingsGroupService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Route("groups")
public class GroupListView extends VerticalLayout {

    private final SavingsGroupService service;
    private final Grid<SavingsGroup> grid = new Grid<>(SavingsGroup.class);

    public GroupListView(SavingsGroupService service) {
        this.service = service;
        add(new H2("Savings Groups"));

        grid.setColumns("id", "groupName", "targetAmount", "adminMemberId");
        grid.setItems(service.findAll());
        add(grid);

        Button create = new Button("Create Group", e -> openCreateDialog());
        add(create);
    }

    private void openCreateDialog() {
        Dialog dialog = new Dialog();
        FormLayout form = new FormLayout();
        TextField groupName = new TextField("Group Name");
        TextField targetAmount = new TextField("Target Amount");
        TextField adminMemberId = new TextField("Admin Member ID");
        form.add(groupName, targetAmount, adminMemberId);

        Button submit = new Button("Create", e -> {
            try {
                BigDecimal amount = new BigDecimal(targetAmount.getValue());
                SavingsGroup g = new SavingsGroup(groupName.getValue(), amount, adminMemberId.getValue());
                service.createGroup(g);
                grid.setItems(service.findAll());
                dialog.close();
            } catch (Exception ex) {
                // simple error handling: keep dialog open for correction
            }
        });
        form.add(submit);
        dialog.add(form);
        dialog.open();
    }
}
