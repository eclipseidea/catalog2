package zab.romik.configuration;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Кодировка приложения, чтобы поддерживать все символы языков
     */
    private static final String APP_ENCODING = "UTF-8";

    /**
     * Кодировать все подряд
     */
    private static final boolean IS_FORCE_ENCODING = true;

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class, DataConfig.class};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new CharacterEncodingFilter(APP_ENCODING, IS_FORCE_ENCODING),
                /*
                Этот фильтр используется для того чтобы исправить ошибку
                выборки списков связей (LazyFetch) из сущностей в шаблонах.

                Второй вариант исправления это использование EagerFetch, но
                мы не можем этот вариант использовать, так как он ударит по
                производительности

                Третий вариант использование аннотации @Transactional, но
                она у нас не работает
                 */
                new OpenEntityManagerInViewFilter()
        };
    }
}
