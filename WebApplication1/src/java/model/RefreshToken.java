package model;

public class RefreshToken {
    private int id;
    private String refreshToken;
    private String tokenNotify;
    private int userId;

    // Constructor
    public RefreshToken() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getTokenNotify() {
        return tokenNotify;
    }

    public void setTokenNotify(String tokenNotify) {
        this.tokenNotify = tokenNotify;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
