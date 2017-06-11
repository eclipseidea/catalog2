package zab.romik.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import zab.romik.exceptions.ResourceNotFoundException;

/**
 * Контроллер для обработки ошибок, для того чтобы не вываливать ошибку
 * на стандартном шаблоне tomcat, а выводить ее красиво, был создан
 * этот контроллер, он ловит на глобальном уровне ошибки
 *
 * @author proweber1
 * @since 0.0.1
 */
@ControllerAdvice
public class ErrorController {

    /**
     * Этот метод используется для того чтобы отображать исключения об
     * отсутствии ресурсов
     *
     * @return Название страницы
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public String renderErrorPage() {
        return "errors/404";
    }
}
