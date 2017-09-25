package cards.utils;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@ControllerAdvice(annotations = RestController.class)
public class ControllerAdvisor {

    @ModelAttribute
    public void addAttributes(HttpServletRequest request, HttpServletResponse response, Model model, @RequestBody String requestString, @RequestHeader(value = "User-Agent") String userAgent) {
        // do whatever you want to do on the request body and header.
        // with request object you can get the request method and request path etc.
        System.out.println("requestString" + requestString);
        System.out.println("userAgent" + userAgent);

    }

}