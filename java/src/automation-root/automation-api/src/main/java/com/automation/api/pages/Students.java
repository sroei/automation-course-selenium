package com.automation.api.pages;

import com.automation.api.components.Create;
import com.automation.api.components.Menu;
import com.automation.api.components.PageNavigator;
import com.automation.api.components.Student;

import java.util.List;

public interface Students extends PageNavigator<Students>, Menu, Create<CreateStudent> {
    Students findByName(String name);

    List<Student> students();
}