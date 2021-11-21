package user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLombok {

    private String name;
    private String gender;
    private String email;
    private String status;

}
