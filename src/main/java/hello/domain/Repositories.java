package hello.domain;

import java.util.ArrayList;
import java.util.List;

import static hello.Constants.UPDATED;

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

    public static Repositories createRepositories() {
        Repositories repositories = new Repositories();
        List<Repo> repos = new ArrayList<>(1);
        repos.add(Repo.createRepo());
        repositories.setRepo(repos);
        repositories.setUpdated(UPDATED);
        return repositories;
    }
}