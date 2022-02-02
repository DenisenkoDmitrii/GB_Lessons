package Lesson_06.service;

import Lesson_06.dto.GetCategoryResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;

public interface CategoryService {

    @GET("categories/{id}")
    Call<GetCategoryResponse> getCategory(@Path("id") int id);

}
