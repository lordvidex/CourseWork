package dev.druid.classwork.classwork11;

import dev.druid.classwork.classwork10.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Date: 18.03.2021
 * Time: 4:04 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Post {
    private String text;
    private User author;
    private String postId;
    private List<User> likes;
    private List<Comment> comments;

    public String getPostId() {
        return postId;
    }

    public Post(String postId,String text, User author) {
        this.postId = postId;
        this.text = text;
        this.author = author;
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public static Post fromList(String[] list){
        return new Post(list[0],list[1],SocialWall.users.get(Integer.parseInt(list[2])));
    }

    void likePost(User loggedInUser){
        this.likes.add(loggedInUser);
    }

    void addComment(User loggedInUser, String comment) {
        this.comments.add(new Comment(postId,loggedInUser,comment));
    }

    public User getAuthor() {
        return author;
    }
    public List<Comment> getComments(){
        return comments;
    }

    public List<User> getLikes(){
        return likes;
    }
}
