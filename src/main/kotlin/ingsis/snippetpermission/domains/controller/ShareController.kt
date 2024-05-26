package ingsis.snippetpermission.domains.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class ShareController {

    @GetMapping("/test")
    fun test(): String {
        return "Como anda la banda?"
    }

}