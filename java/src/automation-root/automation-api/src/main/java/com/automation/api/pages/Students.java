package com.automation.api.pages;

import com.automation.api.components.Create;
import com.automation.api.components.Menu;
import com.automation.api.components.PageNavigator;
import com.automation.api.components.Student;
import com.automation.core.components.Fluent;

import java.io.IOException;
import java.util.List;

public interface Students extends Fluent, PageNavigator<Students>, Menu, Create<CreateStudent> {
    Students findByName(String name) throws IOException;

    List<Student> students() throws IOException;
}