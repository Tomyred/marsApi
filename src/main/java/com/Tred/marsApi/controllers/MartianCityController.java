package com.Tred.marsApi.controllers;

import com.Tred.marsApi.models.MartianCity;
import com.Tred.marsApi.services.MartianCityServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/v1/mars/martiancities")
public class MartianCityController extends BaseControllerImpl<MartianCity, MartianCityServiceImpl>{
}
