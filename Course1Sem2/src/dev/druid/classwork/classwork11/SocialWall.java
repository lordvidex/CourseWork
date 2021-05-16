package dev.druid.classwork.classwork11;

import dev.druid.classwork.classwork10.SubscriptionParser;
import dev.druid.classwork.classwork10.User;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * Date: 18.03.2021
 * Time: 3:55 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class SocialWall {
    static HashMap<String, Post> posts;
    static Map<Integer, User> users;

    public static void main(String[] args) throws IOException {
        loadAllFiles();
        task1();
        task2();
    }

    private static void loadAllFiles() throws IOException {
        // init posts
        posts = new HashMap<>();

        // load users into hashmap
        users = SubscriptionParser.parseUsersFile("src/dev/druid/classwork/classwork10/users.csv")
                .stream().collect(Collectors.toMap(User::getId,
                        user-> user));

        // read posts keys and contents
        List<Post> postContents = readPostFile("src/dev/druid/classwork/classwork11/posts.csv");
        for (Post p : postContents) {
            posts.put(p.getPostId(), p);
        }

        // fetch comments to this posts
        List<Comment> comments = readCommentsFile("src/dev/druid/classwork/classwork11/comments.csv");
        for (Comment c : comments) {
            posts.get(c.getPostId()).addComment(c.getUser(), c.getComment());
        }

        // fetch likes on this posts
        loadLikesAndAddToPost("src/dev/druid/classwork/classwork11/likes.csv");
    }

    private static void task1() {
        Set<User> xenophobes = getXenophobes();
        System.out.println("Below are the users that liked posts of people from their country: ");
        for(User user: xenophobes){
            System.out.println("\t ->"+user);
        }

    }

    private static void task2() {
        Set<User> russianCommenters = findAllUsersCommentingOnRussianPosts();
        System.out.println("Below are the users that commented on all Russian posts: ");
        for (User user : russianCommenters) {
            System.out.println("\t ->" + user);
        }
    }

    private static Set<User> getXenophobes() {
        HashSet<User> users = new HashSet<>();
        // add all the likers from all posts
        for (Map.Entry<String, Post> postEntry : posts.entrySet()) {
            users.addAll(postEntry.getValue().getLikes());
        }

        // filter the users by removing users if they like posts of
        // people not from their country
        for (Map.Entry<String, Post> postEntry : posts.entrySet()) {
            Post p = postEntry.getValue();
            User author = p.getAuthor();
            List<User> likes = p.getLikes();
            for (User x : likes) {
                if (users.contains(x) &&
                        !x.getCountry().equals(author.getCountry())) {
                    users.remove(x);
                }
            }
        }
        return users;
    }

    private static Set<User> findAllUsersCommentingOnRussianPosts() {
        HashSet<User> users = new HashSet<>();
        for (Map.Entry<String, Post> e : posts.entrySet()) {
            Post p = e.getValue();
            if (p.getAuthor().getCountry().equals("Russia")) {
                for (Comment c : p.getComments()) {
                    users.add(c.getUser());
                }
            }
        }
        return users;
    }

    private static void loadLikesAndAddToPost(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");
            posts.get(arr[0]).likePost(users.get(Integer.parseInt(arr[1])));
        }
    }

    public static List<Post> readPostFile(String filename) throws IOException {
        List<Post> posts = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            posts.add(Post.fromList(line.split(",")));
        }
        return posts;
    }

    public static List<Comment> readCommentsFile(String filename) throws IOException {
        List<Comment> comments = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            comments.add(Comment.fromList(line.split(",")));
        }
        return comments;
    }
}
