package ingsis.snippetshare.domains.controller

import ingsis.snippetshare.domains.dto.ShareDTO
import ingsis.snippetshare.domains.model.Share
import ingsis.snippetshare.domains.service.ShareService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@CrossOrigin("*")
class ShareController(@Autowired private val shareService: ShareService) {

    @GetMapping("/test")
    fun test(): String {
        return "Como anda la banda?"
    }

    @PostMapping("/share")
    @ResponseBody
    fun share(principal: Principal, @RequestBody shareDto: ShareDTO): ResponseEntity<Share> {
        val userId = principal.name
        return ResponseEntity(shareService.share(shareDto, userId), HttpStatus.CREATED)
    }

    @GetMapping("/share")
    fun getSharedWithMePosts(principal: Principal): ResponseEntity<List<Share>> {
        val userId = principal.name
        return ResponseEntity(shareService.getSharedPosts(userId), HttpStatus.OK)
    }

    @GetMapping("/share/shared_with_me")
    fun getSharedWithMe(principal: Principal): ResponseEntity<List<Share>> {
        val userId = principal.name
        return ResponseEntity(shareService.getSharedWithMePosts(userId), HttpStatus.OK)
    }
}
