package Lesson_04;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
public class UserRegistrationDTO {

    //@JsonProperty("name") //Сейчас не нужно т.к. name переменной, совпадает с наименованием JSON
    private String name;

    private String job;

    private String email;

    private String password;
}
