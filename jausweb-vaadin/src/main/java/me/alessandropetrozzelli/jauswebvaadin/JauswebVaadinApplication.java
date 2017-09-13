package me.alessandropetrozzelli.jauswebvaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class JauswebVaadinApplication {

    public static void main(String[] args) {
        SpringApplication.run(JauswebVaadinApplication.class, args);
    }

    @Service
    public class MyService {
        public String sayHi() {
            return "Hello Jaus!";
        }

    }

    @Theme("valo")
    @SpringUI(path = "")
    public class VaadinUI extends UI {

        @Autowired
        MyService myService;

        @Override
        protected void init(VaadinRequest request) {
            setContent(new Label(myService.sayHi()));
        }

    }

    @Theme("valo")
    @SpringUI(path = "/2")
    public class FirstVerticalUI extends UI {

        @Autowired
        MyService myService;

        @Override
        protected void init(VaadinRequest request) {
            setContent(new FirstVaadinViewDesignBased());
        }

    }

    public class FirstVaadinViewDesignBased extends FirstVaadinDesign {

    }
}
