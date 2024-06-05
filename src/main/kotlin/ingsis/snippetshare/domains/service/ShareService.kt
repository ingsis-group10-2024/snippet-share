package ingsis.snippetshare.domains.service

import ingsis.snippetshare.domains.dto.ShareDTO
import ingsis.snippetshare.domains.model.Share

interface ShareService {

    fun share(shareDto: ShareDTO, userId: String): Share
    fun getSharedPosts(userId: String): List<Share>
    fun getSharedWithMePosts(userId: String): List<Share>
}
