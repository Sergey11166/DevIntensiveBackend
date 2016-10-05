package hello.domain;

@SuppressWarnings("unused")
public class Repo {

    private String id;

    private String git;

    private String title;

    public Repo() {
    }

    public Repo(String id, String git, String title) {
        this.id = id;
        this.git = git;
        this.title = title;
    }

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

    public static Repo createRepo(String id) {
        Repo repo = new Repo();
        repo.setId(id);
        repo.setGit("github.com/sergey11166/DevIntensive");
        repo.setTitle("");
        return repo;
    }
}