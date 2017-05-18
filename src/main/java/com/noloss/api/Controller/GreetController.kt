package com.noloss.api.Controller

/**
 * Created by Jutssam on 2017/5/18.
 */
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.noloss.api.JsonFormat.Greeting
import org.springframework.web.bind.annotation.RequestParam
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetController{

    val counter = AtomicLong()

    @RequestMapping("/kotlin")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }
}