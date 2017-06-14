package zab.romik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zab.romik.service.PropertiesService;

import java.util.Properties;

@RestController
public class Api {
    /**
     *
     *
     */

    private PropertiesService propertiesService;

    /**
     *
     *
     *
     */

    @Autowired
    public Api(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    /**
     *
     *
     *
     */
    @GetMapping
    private Properties findById(final long id) {
        final Properties properties = propertiesService.findOne(id);
        
        return properties;
    }
}