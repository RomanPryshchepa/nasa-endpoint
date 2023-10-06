package com.bobocode.restApiDemo.controller;

import com.bobocode.restApiDemo.service.NasaService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
public class NasaController {
    private final NasaService nasaService;

    public NasaController(NasaService nasaService) {
        this.nasaService = nasaService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getInfo() {
        return nasaService.getInfo("300");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{sol}")
    public String getInfo(@PathVariable(required = false) @NonNull String sol) {
        return nasaService.getInfo(sol);
    }
}
