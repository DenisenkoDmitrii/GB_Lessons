package Lesson_05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetCategoryResponse {

    //@JsonProperty("id")
    private Integer id;

    private String title;

    private List<Product> products = new ArrayList<>();

}
