package hello.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static hello.Constants.UPDATED;
import static hello.domain.Repo.createRepo;

@SuppressWarnings("unused")
public class Repositories {

    private List<Repo> repo = new ArrayList<>();

    private String updated;

    public Repositories() {
    }

    public Repositories(List<Repo> repo, String updated) {
        this.repo = repo;
        this.updated = updated;
    }

    public List<Repo> getRepo() {
        return repo;
    }
    public void setRepo(List<Repo> repo) {
        this.repo = repo;
    }

    public String getUpdated() {
        return updated;
    }
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public static Repositories createRepositories(String userId) {
        Repositories repositories = new Repositories();

        repositories.setRepo(IntStream
                .rangeClosed(1, 5)
                .mapToObj(index -> createRepo(userId + index))
                .collect(Collectors.toList()));

        repositories.setUpdated(UPDATED);
        return repositories;
    }
}