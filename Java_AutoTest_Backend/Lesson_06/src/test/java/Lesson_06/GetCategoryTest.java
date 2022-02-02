package Lesson_06;

import Lesson_06.db.dao.CategoriesMapper;
import Lesson_06.db.model.Categories;
import Lesson_06.db.model.CategoriesExample;
import Lesson_06.dto.GetCategoryResponse;
import Lesson_06.service.CategoryService;
import Lesson_06.util.RetrofitUtils;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/*
Lesson_06 (GB.Java_AutoTest_Backend)
Denisenko Dmitriy (02.02.2022)
 */
public class GetCategoryTest {
    static CategoryService categoryService;
    static String resource;
    static InputStream inputStream;
    static SqlSessionFactory sqlSessionFactory;
    static SqlSession session;
    static CategoriesMapper categoriesMapper;

    CategoriesExample example = new CategoriesExample();


    @BeforeAll
    static void beforeAll() throws IOException {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);

        resource = "mybatisConfig.xml"; //Путь к файлу с настройками подключения к БД
        inputStream = Resources.getResourceAsStream(resource); //Читаем фаил
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //Создаём сессию
        session = sqlSessionFactory.openSession(); //Создаём сессию взаимодействия с СУБД
        categoriesMapper = session.getMapper(CategoriesMapper.class); //Интерфейс взаимодействия с БД
    }

    @SneakyThrows
    @Test
    void getCategoryByIdPositiveTest() {
        Response<GetCategoryResponse> response = categoryService.getCategory(1).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true)); //Если выбрать метод code(), с его помощью можно проверить конкретный код ответа.
        assertThat(response.body().getId(), equalTo(1));
        assertThat(response.body().getTitle(), equalTo("Food"));
        response.body().getProducts().forEach(product -> assertThat(product.getCategoryTitle(), equalTo("Food")));

        Categories categories = categoriesMapper.selectByPrimaryKey(1);
        assertThat(categories.getTitle(), equalTo("Food"));
        assertThat(categoriesMapper.selectByPrimaryKey(2).getTitle(), equalTo("Electronic"));
        assertThat(categoriesMapper.selectByPrimaryKey(3).getTitle(), equalTo("Furniture"));



    }
}
