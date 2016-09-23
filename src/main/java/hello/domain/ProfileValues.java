package hello.domain;

import static hello.Constants.UPDATED;

@SuppressWarnings("unused")
class ProfileValues {

    private int homeTask;

    private int projects;

    private int linesCode;

    private int rating;

    private String updated;

    public int getHomeTask() {
        return homeTask;
    }
    public void setHomeTask(int homeTask) {
        this.homeTask = homeTask;
    }

    public int getProjects() {
        return projects;
    }
    public void setProjects(int projects) {
        this.projects = projects;
    }

    public int getLinesCode() {
        return linesCode;
    }
    public void setLinesCode(int linesCode) {
        this.linesCode = linesCode;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUpdated() {
        return updated;
    }
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public static ProfileValues createProfileValues() {
        ProfileValues values = new ProfileValues();
        values.setHomeTask(7);
        values.setProjects(5);
        values.setLinesCode(25000);
        values.setRating(10);
        values.setUpdated(UPDATED);
        return values;
    }
}
