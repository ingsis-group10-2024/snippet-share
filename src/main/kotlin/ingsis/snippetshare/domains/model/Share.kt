package ingsis.snippetshare.domains.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date
import java.util.UUID

/** This model represents the shared snippets */

@Entity
@Table(name = "share")
class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: UUID? = null

    @Column(name = "snippetId", nullable = false)
    var snippetId: String? = null

    // User with whom the snippet is shared
    @Column(name = "sharedId", nullable = false)
    var sharedId: String? = null

    // User who is sharing the snippet
    @Column(name = "sharerId", nullable = false)
    var sharerId: String? = null

    @Column(name = "createdAt", nullable = false)
    var createdAt: Date? = null

    @Column(name = "updatedAt", nullable = true)
    var updatedAt: Date? = null

    constructor(id: UUID?, snippetId: String?, sharedId: String?, sharerId: String?, createdAt: Date?, updatedAt: Date?) {
        this.id = id
        this.snippetId = snippetId
        this.sharedId = sharedId
        this.sharerId = sharerId
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }

    constructor(snippetId: String?, sharedId: String?, sharerId: String?) {
        this.snippetId = snippetId
        this.sharedId = sharedId
        this.sharerId = sharerId
        this.createdAt = Date()
    }
}
