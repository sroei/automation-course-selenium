package com.automation.api.pages;

import com.automation.api.components.Student;

import java.util.List;

public interface Students {
    Students findByName(String name);
    List<Student> students();
}
