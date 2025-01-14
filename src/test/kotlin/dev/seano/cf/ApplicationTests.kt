package dev.seano.cf

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTests {

    @Test
    fun `test root api route`() = testApplication {
        application { module() }
        val response = client.get("/api")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("🐈", response.bodyAsText())
    }
}
