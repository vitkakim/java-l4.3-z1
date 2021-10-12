package ru.netology.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Issue implements Comparable<Issue> {
    private int id;
    private int number;
    private String name;
    private String author;
    private boolean open;
    private String date;
    private String assignee;
    private Set<String> labels = new HashSet<String>();

    public Issue(int id, int number, String name, String author, boolean open, String date, String assignee, Set<String> labels) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.author = author;
        this.open = open;
        this.date = date;
        this.assignee = assignee;
        this.labels = labels;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Issue o) {
        Issue issue = (Issue) o;
        return this.number - issue.number;
    }
}
