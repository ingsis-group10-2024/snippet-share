package ingsis.snippetshare.domains.repository

import ingsis.snippetshare.domains.model.Share
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ShareRepository: JpaRepository<Share, UUID> {

    @Query("SELECT s FROM Share s WHERE s.sharerId = :userId")
    fun findShared(userId: String): List<Share>

    @Query("SELECT s FROM Share s WHERE s.sharedId = :userId")
    fun findSharedWith(userId: String): List<Share>

}