package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;

public class IssueRepository {
    private Collection<Issue> items = new ArrayList<>();

    public void save(Issue item) {
        items.add(item);
    }

    public Collection<Issue> findAll() {
        return items;
    }

}
