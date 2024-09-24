package org.example.client

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

interface HTTPClient {
  fun get(URL: String) : String
}

abstract class HTTPClientImpl : HTTPClient

object OKHTTPWrapper : HTTPClientImpl() {

  private val client = OkHttpClient()

  override fun get(URL: String) = with(client) {
    newCall(Request.Builder().url(URL).build()).execute().use { response ->
      if (!response.isSuccessful) throw OKHTTPException("Unexpected code $response")

      response.body!!.string()
    }
  }
}

class OKHTTPException(name: String) : IOException(name)
