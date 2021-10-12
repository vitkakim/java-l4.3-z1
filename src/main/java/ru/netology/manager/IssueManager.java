package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.Arrays;

public class IssueManager {
    private IssueRepository repo;


    public IssueManager(IssueRepository repo) {
        this.repo = repo;
    }

    public void add(Issue item) {
        repo.save(item);
    }

    public Issue[] showOpenOrClose(boolean open) {
        Issue[] result = new Issue[0];
        for (Issue issue : repo.findAll()) {
            if (issue.isOpen() == open) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Issue[] filterByAuthor(String author) {
        Issue[] result = new Issue[0];
        for (Issue issue : repo.findAll()) {
            if (issue.getAuthor() == author) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Issue[] filterByLabel(String label) {
        Issue[] result = new Issue[0];
        for (Issue issue : repo.findAll()) {
            if (issue.getLabels().contains(label)) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


    public Issue[] filterByAssignee(String assignee) {
        Issue[] result = new Issue[0];
        for (Issue issue : repo.findAll()) {
            if (issue.getAssignee().contains(assignee)) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        Arrays.sort(result);
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
