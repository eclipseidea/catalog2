package zab.romik.configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * TODO: Кодировку надо вынести в конфигурацию, если в конфиге не будет задано, то юзать UTF-8
 */
@Configuration
@EnableWebMvc
@ComponentScan("zab.romik.*")
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    /**
     * Контекст приложения
     */
    private ApplicationContext applicationContext;

    /**
     * Папка в которой у нас будут лежать шаблоны системы
     */
    private static final String TEMPLATE_PREFIX = "/WEB-INF/thymeleaf/";

    /**
     * Расшрение файлов для шаблонов внутри системы, мы
     * используем .html процессор
     */
    private static final String TEMPLATE_SUFFIX = ".html";

    /**
     * Говорим чтоб thymeleaf обрабатывался первым в цепочке
     */
    private static final int THYMELEAF_VIEW_RESOLVER_ORDER = 1;

    /**
     * Это настройка шаблонизатора thymeleaf, реализовано по уроку
     * интеграции со спрингом из официальной документации, смотрите
     * ссылку
     * <p>
     * <a href="http://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html#integrating-thymeleaf-with-spring">
     * Spring Integration
     * </a>
     *
     * @return Сконфигурированный движок шаблонов
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix(TEMPLATE_PREFIX);
        templateResolver.setSuffix(TEMPLATE_SUFFIX);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(true);

        return templateResolver;
    }

    /**
     * Этот метод возвращает класс для работы с самим движком шаблонов
     * thymeleaf, этот метод описан в документации по интеграции thymeleaf
     * со spring, для ссылки на документацию смотрите JavaDoc
     * {@link WebConfig#templateResolver()}
     *
     * @return Движок для работы с шаблонами
     */
    @Bean
    public SpringTemplateEngine templateEngine() {
        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();

        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        templateEngine.addDialect(new LayoutDialect());

        return templateEngine;
    }

    /**
     * Резолвер для работы с шаблонами
     *
     * @return Резолвер
     */
    @Bean
    public ThymeleafViewResolver viewResolver() {
        final ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(THYMELEAF_VIEW_RESOLVER_ORDER);
        viewResolver.setCharacterEncoding("UTF-8");

        return viewResolver;
    }

    /**
     * Регистрирует ресурсы для spring mvc приложения, такие как
     * css, js, image файлы
     *
     * @param registry Реестр статических ресурсов
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setApplicationContext(final ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }
}
