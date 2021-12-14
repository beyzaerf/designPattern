public class User {
    private int userId;
    private String name;
    private String address;
    private String phoneNo;
    private String email;

    public User(int userId, String name, String address, String phoneNo, String email) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.phoneNo = phoneNo;
        this.userId = userId;

    }
    public int getUserId() { return userId; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPhoneNo() { return phoneNo; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
    public void setName(String name) { this.name = name; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public void setUserId(int userId) { this.userId = userId; }
}
