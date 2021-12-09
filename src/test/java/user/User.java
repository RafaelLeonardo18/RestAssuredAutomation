package user;

import lombok.*;
import lombok.Data;
import payload.Payload;

import java.util.Objects;

@Data
@Builder
@Getter
@Setter
public class User extends Payload {

    private String name;
    private String gender;
    private String email;
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getGender(), user.getGender()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getStatus(), user.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGender(), getEmail(), getStatus());
    }
}