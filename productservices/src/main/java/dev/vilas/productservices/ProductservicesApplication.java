package dev.vilas.productservices;

import dev.vilas.productservices.inheritancedemo.singletable.Student;
import dev.vilas.productservices.inheritancedemo.singletable.StudentRepository;
import dev.vilas.productservices.inheritancedemo.singletable.User;
import dev.vilas.productservices.inheritancedemo.singletable.UserRepository;
import dev.vilas.productservices.models.Category;
import dev.vilas.productservices.models.Product;
import dev.vilas.productservices.repositories.CategoryRepositories;
import dev.vilas.productservices.repositories.ProductRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ProductservicesApplication implements CommandLineRunner {

    private StudentRepository studentRepository;
    private UserRepository userRepository;
    private final CategoryRepositories categoryRepository;
    private final ProductRepositories productRepositories;


    public ProductservicesApplication(StudentRepository studentRepository,
            UserRepository userRepository,
                                      CategoryRepositories categoryRepository,
                                      ProductRepositories productRepositories){
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepositories = productRepositories;
    }

    public static void main(String[] args) {

        SpringApplication.run(ProductservicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Student student = new Student();
        student.setName("Vilas");
        student.setEmail("vilas@gamil.com");
        student.setAttendance(90.0);
        student.setPsp(80.0);
        studentRepository.save(student);

        User user = new User();
        user.setName("Priya");
        user.setEmail("priya@gmail.com");
        userRepository.save(user);

        Category category = new Category();
        category.setName("Apple Devices");

        Category savedCategory = categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("iPhone 15 Pro");
       product.setDescription("The best iPhone Ever");
       product.setCategory(category);
        product.setPrice(50.0);

        productRepositories.save(product);

        Category category1 = categoryRepository.findById(UUID.fromString("8548C247-7DCB-4803-A052-8E2F8836C576")).get();

        System.out.println("Category name is: " + category1.getName());
        System.out.println("Printing all products in the category");
        Thread.sleep(1000);

        for (Product product1: category1.getProducts()) {
            try {
               System.out.println(product1.getTitle());
            } catch (Exception e) {
                System.out.println(e.getMessage());
           }
        }

    }
}
