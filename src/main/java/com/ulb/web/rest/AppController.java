package com.ulb.web.rest;

import com.ulb.web.dto.ServerDTO;
import com.ulb.web.util.AlipayInfoGetter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/serverInfo.shtml",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ServerDTO> getInfo() {

        LOGGER.debug("REST request to get Server Info");
        ServerDTO serverInfoDTO = new ServerDTO();

        serverInfoDTO.setServerName("ulb");
        serverInfoDTO.setPort("8080");

        return new ResponseEntity<>(serverInfoDTO, HttpStatus.OK);
    }


    @RequestMapping(value = "/serverInfo.shtml",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Void> getInfo(@RequestBody ServerDTO serverDTO) {
        LOGGER.debug("REST request to post Server Info:"+ serverDTO.getPort());
        LOGGER.debug("REST request to post Server Info:"+ serverDTO.getServerName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
