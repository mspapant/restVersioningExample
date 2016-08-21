package com.mspapant.example.restVersion.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The user controller.
 *
 * @author : Manos Papantonakos on 19/8/2016.
 */
@Controller
@Api(value = "user", description = "Operations about users")
public class UserController {

    /**
     * Return the user.
     *
     * @return the user
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/user")
    @ApiOperation(value = "Returns user", notes = "Returns the user", tags = {"GET", "User"})
    public String getUserV1() {
        return "User V1";
    }

    /**
     * Return the user.
     *
     * @return the user
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/api/v2/user")
    @ApiOperation(value = "Returns user", notes = "Returns the user", tags = {"GET", "User"})
    public String getUserV2() {
        return "User V2";
    }
}
