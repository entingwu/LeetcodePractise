package design;

import java.util.*;

/*http://www.guoting.org/leetcode/leetcode-355-design-twitter/*/
public class Twitter {

    class Tweet {
        int tweetId;
        int timeStamp;
        public Tweet(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }
    // TweetMap <userId, Deque<Tweet>>
    private Map<Integer, Deque<Tweet>> tweetMap = new HashMap<>();

    // FollowMap <followerId, Set<followeeId>>
    private Map<Integer, Set<Integer>> followMap = new HashMap<>();

    // TimeStamp
    private int timeStamp;

    /** Initialize your data structure here. */
    public Twitter() {
        timeStamp = 0;
    }

    /** Compose a new tweet. tweetMap */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, timeStamp++);
        Deque<Tweet> deque = new ArrayDeque<>(10);
        if (tweetMap.containsKey(userId)) {
            deque = tweetMap.get(userId);
            if (tweetMap.get(userId).size() >= 10) {
                deque.poll();//F I L O
            }
        }
        deque.offer(tweet);//3 2 1
        tweetMap.put(userId, deque);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
     * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>(10);
        PriorityQueue<Tweet> pq = new PriorityQueue<>(10, (x, y) -> x.timeStamp - y.timeStamp);// Minheap
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        // self tweets
        pq.addAll(tweetMap.getOrDefault(userId, new ArrayDeque<>()));
        // followee tweets
        for (int followee : followees) {
            pq.addAll(tweetMap.getOrDefault(followee, new ArrayDeque<>()));
            while (pq.size() > 10) {
                pq.poll();
            }
        }
        // Desc
        while (!pq.isEmpty()) {
            newsFeed.add(0, pq.poll().tweetId);//越挤越大, insert head
        }
        return newsFeed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) { return; }
        Set<Integer> followees = followMap.containsKey(followerId)?
                followMap.get(followerId) : new HashSet<>();
        followees.add(followeeId);
        followMap.put(followerId, followees);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.getNewsFeed(1);

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.getNewsFeed(1);

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        twitter.getNewsFeed(1);
    }
}
