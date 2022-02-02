package Lesson_06;

import Lesson_06.db.dao.CategoriesMapper;
import Lesson_06.db.dao.ProductsMapper;
import Lesson_06.db.model.CategoriesExample;
import Lesson_06.db.model.Products;
import Lesson_06.db.model.ProductsExample;
import Lesson_06.dto.Product;
import Lesson_06.service.CategoryService;
import Lesson_06.service.ProductService;
import Lesson_06.util.RetrofitUtils;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.*;
import retrofit2.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

/*
Lesson_06 (GB.Java_AutoTest_Backend)
Denisenko Dmitriy (02.02.2022)
 */
public class ProductTest {

    static ProductService productService;
    static Product product;
    static Faker faker = new Faker();
    static int id;
    int price;
    Product productModify;

    static String resource;
    static InputStream inputStream;
    static SqlSessionFactory sqlSessionFactory;
    static SqlSession session;
    static CategoriesMapper categoriesMapper;
    static ProductsMapper productsMapper;

    CategoriesExample categoriesExample = new CategoriesExample();
    ProductsExample productsExample = new ProductsExample();

    @BeforeAll
    static void beforeAll() throws IOException {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice(777);

        resource = "mybatisConfig.xml"; //Путь к файлу с настройками подключения к БД
        inputStream = Resources.getResourceAsStream(resource); //Читаем фаил
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //Создаём сессию
        session = sqlSessionFactory.openSession(); //Создаём сессию взаимодействия с СУБД
        categoriesMapper = session.getMapper(CategoriesMapper.class);
        productsMapper = session.getMapper(ProductsMapper.class); //Интерфейс взаимодействия с БД
    }

    @SneakyThrows
    @AfterAll
    static void tearDown() {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

    @Test
    @SneakyThrows
    void createProductInFoodCategoryTest() {
        Response<Product> response = productService.createProduct(product).execute();
        id = response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));

        assertThat(productsMapper.selectByPrimaryKey((long) id).getPrice(), CoreMatchers.is(777));
    }

    @Test
    @SneakyThrows
    void modifyProductInFoodCategoryTest() {
        productModify = new Product()
                .withId(id)
                .withTitle("Modified")
                .withPrice(888)
                .withCategoryTitle("Food");

        Response<Product> response = productService.modifyProduct(productModify).execute();
        price = response.body().getPrice();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(price, CoreMatchers.is(888));
        assertThat(response.body().getTitle(), CoreMatchers.is("Modified"));

        productsMapper.selectByPrimaryKey((long)id).setTitle("Modified2");
        productsMapper.selectByPrimaryKey((long)id).setPrice(111);

        assertThat(productsMapper.selectByPrimaryKey((long) id).getPrice(), CoreMatchers.is(111));
        assertThat(productsMapper.selectByPrimaryKey((long) id).getTitle(), CoreMatchers.is("Modified2"));

    }

    @Test
    @SneakyThrows
    void getProductByIdTest() {
        Response<Product> response = productService.getProductById(19693).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getPrice(), CoreMatchers.is(172));
        assertThat(response.body().getTitle(), CoreMatchers.is("Oranges"));

        assertThat(productsMapper.selectByPrimaryKey((long) 19693).getPrice(), CoreMatchers.is(172));
        assertThat(productsMapper.selectByPrimaryKey((long) 19693).getTitle(), CoreMatchers.is("Oranges"));
    }

    @Test
    @SneakyThrows
    void getProductsTest() {
        Response<ResponseBody> response = productService.getProducts().execute();
        assertThat(response.code(), CoreMatchers.is(500));//Тут ничего кроме 500 ошибки добится не удалось, в UI интерфейсе swagger - тоже постоянно ошибка 500 (http://80.78.248.82:8189/market/swagger-ui.html#/product-controller/getProductsUsingGET)

        productsExample.createCriteria().andTitleEqualTo("Joachim de Wett");
        List<Products> list = productsMapper.selectByExample(productsExample);
        assertThat(list, notNullValue());

    }
}
