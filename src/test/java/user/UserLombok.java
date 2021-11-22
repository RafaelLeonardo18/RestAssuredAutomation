package user;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import payload.Payload;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class UserLombok extends Payload {

    private String name;
    private String gender;
    private String email;
    private String status;

}