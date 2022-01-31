package Lesson_05.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@With
public class Product {
    //@JsonProperty("id")
    private Integer id;

    private String title;

    private Integer price;

    private String categoryTitle;
}
