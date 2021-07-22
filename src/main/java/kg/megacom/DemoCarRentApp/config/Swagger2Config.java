package kg.megacom.DemoCarRentApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    public static final String CAR = "Автопарк";
    public static final String CLIENT = "Клиенты";
    public static final String ORDERS = "Заказы";
    public static final String TARIFF = "Тарифы";
    public static final String LOCATIONS = "Локация";
    public static final String CATEGORY = "Авто категории";
    public static final String CARDESCRIPTION = "Описание авто";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("kg.megacom.DemoCarRentApp.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo())
                .tags(new Tag(CAR, ""))
                .tags(new Tag(CLIENT, ""))
                .tags(new Tag(ORDERS, ""))
                .tags(new Tag(TARIFF, ""))
                .tags(new Tag(LOCATIONS, ""))
                .tags(new Tag(CATEGORY, ""))
                .tags(new Tag(CARDESCRIPTION, ""));
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("DemoCarRentApp")
                .description("Бэкенд для проекта DemoCarRentApp")
                .version("1.0.0")
                .contact(new Contact("Mashanlo Ramazan", "http://www.megacom.kg", "mashanloram.92@gmail.com"))
                .build();
    }
}


