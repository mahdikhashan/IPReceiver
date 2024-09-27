package org.example.client

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

interface IHTTPClient

abstract class AbstractHTTPClient : IHTTPClient {
  abstract fun get(url: String) : String
}

class OKHTTPClient : AbstractHTTPClient() {

  private val client = OkHttpClient()

  override fun get(url: String) = with(client) {
    newCall(Request.Builder().url(url).build()).execute().use { response ->
      if (!response.isSuccessful) throw OKHTTPClientException("Unexpected code $response")

      response.body!!.string()
    }
  }
}

class OKHTTPClientException(name: String) : IOException(name)

object ClientFactory {
  fun getHttpClient(clientName: Clients): AbstractHTTPClient = when (clientName) {
    Clients.OKHttp -> OKHTTPClient()
  }
}

val defaultHttpClient = Clients.OKHttp
val httpClient = ClientFactory.getHttpClient(defaultHttpClient)
