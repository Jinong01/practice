package pojo;

public class User {
    private int id;
    private String userId;
    private String userPwd;

    public User(String userId, String userPwd) {
        this.userId = userId;
        this.userPwd = userPwd;
    }


    public User(int id, String userId, String userPwd) {
        this.id = id;
        this.userId = userId;
        this.userPwd = userPwd;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
