package Database; // Adjust package name as needed

public class Employee {
    private int id;
    private String username;
    private String password; // Optional to store or handle this securely

    public Employee(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password; // Could be null
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", username=" + username + "]";
    }
}
