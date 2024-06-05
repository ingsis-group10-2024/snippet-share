package ingsis.snippetshare.domains.service.impl

import ingsis.snippetshare.domains.dto.ShareDTO
import ingsis.snippetshare.domains.model.Share
import ingsis.snippetshare.domains.repository.ShareRepository
import ingsis.snippetshare.domains.service.ShareService
import ingsis.snippetshare.error.HTTPError
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class ShareService(private val shareRepository: ShareRepository) : ShareService {

    override fun share(shareDto: ShareDTO, userId: String): Share {
        if (shareDto.sharedId == userId) throw HTTPError("Conflict, can't share your snippet to yourself", HttpStatus.CONFLICT)
        val share = Share(
            shareDto.snippetId,
            shareDto.sharedId,
            userId
        )
        return this.shareRepository.save(share)
    }

    override fun getSharedPosts(userId: String): List<Share> {
        return this.shareRepository.findShared(userId)
    }

    override fun getSharedWithMePosts(userId: String): List<Share> {
        return this.shareRepository.findSharedWith(userId)
    }
}
