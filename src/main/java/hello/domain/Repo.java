package hello.domain;

@SuppressWarnings("unused")
public class Repo {

    private String id;

    private String git;

    private String title;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getGit() {
        return git;
    }
    public void setGit(String git) {
        this.git = git;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public static Repo createRepo() {
        Repo repo = new Repo();
        repo.setId("57651280a38f231d00a6ccbe");
        repo.setGit("github.com/sergey11166/DevIntensive");
        repo.setTitle("");
        return repo;
    }
}