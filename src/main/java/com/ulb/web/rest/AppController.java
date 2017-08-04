package com.ulb.web.rest;

import com.ulb.web.dto.ServerDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangpeng on 03/08/2017.
 */

@RestController
@Scope(value="prototype")
@RequestMapping("ulb")
public class AppController {

    public static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @RequestMapping(value = "/serverInfo",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ServerDTO> getInfo() {
        LOGGER.debug("REST request to get Server Info");
        ServerDTO serverInfoDTO = new ServerDTO();

        serverInfoDTO.setServerName("ulb");
        serverInfoDTO.setPort("8080");
        return new ResponseEntity<>(serverInfoDTO, HttpStatus.OK);
    }
}
