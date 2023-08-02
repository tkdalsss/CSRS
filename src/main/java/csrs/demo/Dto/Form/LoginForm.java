package csrs.demo.Dto.Form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {

    @NotEmpty(message = "학번은 필수로 입력해야합니다.")
    private String studentId;

    @NotEmpty(message = "비밀번호는 필수로 입력해야합니다.")
    private String password;

}
