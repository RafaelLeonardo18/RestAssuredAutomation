package user;

import lombok.*;
import lombok.Data;
import payload.Payload;

@Data
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class UserLombok extends Payload {

    private String name;
    private String gender;
    private String email;
    private String status;

}