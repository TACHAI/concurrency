package com.tachai;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by @Author tachai
 * date 2018/7/2 23:36
 *
 * @Email 1206966083@qq.com
 */
@Slf4j
@Controller
public class TestCotroller {
    @RequestMapping("/test")
    public String test(){
     return new String("2333");
    }
}
