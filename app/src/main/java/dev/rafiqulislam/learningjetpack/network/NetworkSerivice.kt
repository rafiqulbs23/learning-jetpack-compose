package dev.rafiqulislam.learningjetpack.network

class NetworkService constructor(builder:Builder) {
    val protocol: String?
    val host: String?
    val path: String?

    init {
        this.protocol = builder.protocol ?: throw IllegalArgumentException("Protocol must be set")
        this.host = builder.host ?: throw IllegalArgumentException("Host must be set")
        this.path = builder.path ?: throw IllegalArgumentException("Path must be set")
    }

    fun performRequest() {
        println("Performing request to $protocol://$host$path")
    }


     class Builder{
        var protocol: String? = null
            private set
        var host: String? = null
            private set
        var path: String? = null
            private set

        fun protocol(protocol: String) = apply { this.protocol = protocol }
        fun host(host: String) = apply { this.host = host }
        fun path(path: String) = apply { this.path = path }
        fun build(): NetworkService {
            if (protocol == null || host == null || path == null) {
                throw IllegalArgumentException("Protocol, host, and path must be set")
            }
            return NetworkService(this)
        }

    }
}

fun main() {
    val service = NetworkService.Builder()
        .protocol("https")
        .host("api.example.com")
        .path("/v1/resource")
        .build()
    service.performRequest()

    println("NetworkService created with protocol: ${service.protocol}, host: ${service.host}, path: ${service.path}")
}