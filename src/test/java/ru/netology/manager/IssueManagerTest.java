package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    Issue book1 = new Issue(1, 111, "Error", "man", true, "10.11.2020",
            "someone", Set.of("Component: Groovy", "status: in progress"));
    Issue book2 = new Issue(2, 112, "Modified", "woman", false, "10.01.2021",
            "man", Set.of("status: decline"));
    Issue book3 = new Issue(3, 110, "Error", "someone", true, "10.10.2021",
            "somebody", Set.of(""));
    Issue book4 = new Issue(4, 10, "Mistake", "somebody", true, "01.09.2021",
            "someone", Set.of("Component: Groovy", "status: in progress"));

    IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
    }

    @Test
    @Disabled
    void shouldAddProduct() {
        Collection<Issue> actual = repository.findAll();
        System.out.println(actual);
    }

    @Test
    void shouldShowOpenedIssue() {
        Issue[] actual = manager.showOpenOrClose(true);
        Issue[] expected = new Issue[]{book4, book3, book1};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldShowClosedIssue() {
        Issue[] actual = manager.showOpenOrClose(false);
        Issue[] expected = new Issue[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFilterByAuthor() {
        Issue[] actual = manager.filterByAuthor("man");
        Issue[] expected = new Issue[]{book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFilterByLabel() {
        Issue[] actual = manager.filterByLabel("Component: Groovy");
        Issue[] expected = new Issue[]{book4, book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFilterByAssignee() {
        Issue[] actual = manager.filterByAssignee("someone");
        Issue[] expected = new Issue[]{book4, book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldChangeForClose() {
        manager.closedById(3);
        boolean actual = book3.isOpen();
        assertFalse(actual);
    }

    @Test
    void shouldChangeForOpen() {
        manager.openById(2);
        boolean actual = book2.isOpen();
        assertTrue(actual);
    }
}