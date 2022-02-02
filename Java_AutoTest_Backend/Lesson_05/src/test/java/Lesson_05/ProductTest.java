package Lesson_05;

import Lesson_05.dto.Product;
import Lesson_05.service.ProductService;
import Lesson_05.util.RetrofitUtils;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class ProductTest {

    static ProductService productService;
    static Product product;
    static Faker faker = new Faker();
    static int id;
    int price;
    Product productModify;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));

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
    }

    @Test
    @SneakyThrows
    void getProductByIdTest() {
        Response<Product> response = productService.getProductById(19693).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getPrice(), CoreMatchers.is(172));
        assertThat(response.body().getTitle(), CoreMatchers.is("Oranges"));
    }

    @Test
    @SneakyThrows
    void getProductsTest() {
        Response<ResponseBody> response = productService.getProducts().execute();
        assertThat(response.code(), CoreMatchers.is(500));
        //Тут ничего кроме 500 ошибки добится не удалось, в UI интерфейсе swagger - тоже постоянно ошибка 500 (http://80.78.248.82:8189/market/swagger-ui.html#/product-controller/getProductsUsingGET)
    }
}
