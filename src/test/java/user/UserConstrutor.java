package user;

import payload.Payload;

import java.util.Objects;

public class UserConstrutor extends Payload {

    private String name;
    private String gender;
    private String email;
    private String status;

    public UserConstrutor() {}

    public UserConstrutor(String name, String gender, String email, String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserConstrutor that = (UserConstrutor) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getGender(), that.getGender()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGender(), getEmail(), getStatus());
    }

    @Override
    public String toString() {
        return "UserConstrutor{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}