package ru.learnup.homework21.translations;

import lombok.Data;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
@Data
public class Resource {

    private ResourceBundleMessageSource resource;

    public Resource() {
        resource = new ResourceBundleMessageSource();
        resource.setBasename("text");
    }
}
