package com.noloss.api.Controller;

import com.noloss.api.Model.User;
import com.noloss.api.Service.UserService;
import org.springframework.stereotype.Controller;
import static java.lang.Math.random;

@Controller
public class CommonController {
    /**
     * Create InviteCode
     * Random Code whose length is 6
     */
    public String inviteCode(Integer len){
        String box = "1234567890abcdefghijklmnopqrstuvwxyz";
        Integer i = 0;
        String code = "";
        while (i < len) {
            i++;
            Integer k = (int)(box.length() * random());
            code += (box.charAt(k));
        }
        System.out.println(code);
        return code.toString();
    }

}