package dev.druid.classwork.classwork11;

import dev.druid.classwork.classwork10.SubscriptionParser;
import dev.druid.classwork.classwork10.User;

/**
 * Created by IntelliJ IDEA
 * Date: 18.03.2021
 * Time: 4:09 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Comment {
    // post Id under which comment was written
    private String postId;
    // user who wrote the comment
    private User user;
    // comment written
    private String comment;

    public String getPostId() {
        return postId;
    }

    public Comment(String postId, User user, String comment){
        this.postId  = postId;
        this.user = user;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }
    public static Comment fromList(String[] list){
        return new Comment(list[0],SocialWall.users.get(Integer.parseInt(list[1])),list[2]);
    }
}
