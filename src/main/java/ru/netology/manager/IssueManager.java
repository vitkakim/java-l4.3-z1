package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.*;

public class IssueManager {
    private IssueRepository repo;


    public IssueManager(IssueRepository repo) {
        this.repo = repo;
    }

    public void add(Issue item) {
        repo.save(item);
    }

    public List<Issue> showOpenOrClose(boolean open) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repo.findAll()) {
            if (issue.isOpen() == open) {
                result.add(issue);
            }
        }
        Collections.sort(result);
        return result;
    }

    public List<Issue> filterByAuthor(String author) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repo.findAll()) {
            if (issue.getAuthor() == author) {
                result.add(issue);
            }
        }
        Collections.sort(result);
        return result;
    }

    public List<Issue> filterByLabel(String label) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repo.findAll()) {
            if (issue.getLabels().contains(label)) {
                result.add(issue);
            }
        }
        Collections.sort(result);
        return result;
    }


    public List<Issue> filterByAssignee(String assignee) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repo.findAll()) {
            if (issue.getAssignee() == assignee) {
                result.add(issue);
            }
        }
        Collections.sort(result);
        return result;
    }

    public void closedById(int id) {
        for (Issue issue : repo.findAll()) {
            if (issue.getId() == id) {
                issue.setOpen(false);
            }
        }
    }

    public void openById(int id) {
        for (Issue issue : repo.findAll()) {
            if (issue.getId() == id) {
                issue.setOpen(true);
            }
        }
    }
}
