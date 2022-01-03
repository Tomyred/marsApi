package com.Tred.marsApi.controllers;

import com.Tred.marsApi.models.Martian;
import com.Tred.marsApi.services.MartianServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/v1/mars/martians")
public class MartianController extends BaseControllerImpl<Martian, MartianServiceImpl> {

}
