package Lesson_06;

import Lesson_06.db.dao.CategoriesMapper;
import Lesson_06.db.model.Categories;
import Lesson_06.db.model.CategoriesExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
Lesson_06 (GB.Java_AutoTest_Backend)
Denisenko Dmitriy (01.02.2022)
 */
public class Lesson_06 {

    public static void main(String[] args) throws IOException {

        /*
        String resource = "mybatisConfig.xml"; //Путь к файлу с настройками подключения к БД
        InputStream inputStream = Resources.getResourceAsStream(resource); //Читаем фаил
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //Создаём сессию
        SqlSession session = sqlSessionFactory.openSession(); //Создаём сессию взаимодействия с СУБД
        CategoriesMapper categoriesMapper = session.getMapper(CategoriesMapper.class); //Интерфейс взаимодействия с БД
        CategoriesExample example = new CategoriesExample(); //Создаём объект

        example.createCriteria().andIdEqualTo(1);
        List<Categories> list = categoriesMapper.selectByExample(example);

        System.out.println(list);

         */

    }
}
