package hello.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import hello.Constants;

import static hello.Constants.USED_ID;

/**
 * @author Sergey Vorobyev
 */

@SuppressWarnings("unused")
public class LikesData {

    private int homeTask;
    private int projects;
    private int linesCode;
    private List<String> likesBy;
    private int rait;
    private String updated;
    private int rating;

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

    public List<String> getLikesBy() {
        return likesBy;
    }
    public void setLikesBy(List<String> likesBy) {
        this.likesBy = likesBy;
    }

    public int getRait() {
        return rait;
    }
    public void setRait(int rait) {
        this.rait = rait;
    }

    public String getUpdated() {
        return updated;
    }
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public static LikesData createLikeData() {
        LikesData data = new LikesData();
        data.setHomeTask(7);
        data.setProjects(5);
        data.setLinesCode(1050);
        data.setLikesBy(Collections.singletonList(USED_ID));
        data.setRait(6);
        data.setUpdated(Constants.UPDATED);
        data.setRating(7);
        return data;
    }

    public static LikesData createUnlikeData() {
        LikesData data = createLikeData();
        data.setLikesBy(new ArrayList<>());
        data.setRating(6);
        return data;
    }
}
