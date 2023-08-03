package csrs.demo.Dto.Form;

import csrs.demo.Dto.Enum.Major;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateForm {

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;

    @NotEmpty(message = "학번은 필수로 입력해야합니다.")
    private String studentId;

    @NotEmpty(message = "비밀번호는 필수로 입력해야합니다.")
    private String password;

    private Major major;

}
