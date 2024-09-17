package org.example

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import kotlinx.serialization.json.Json

private const val API = "https://api.ipify.org?format=json"

private val client = OkHttpClient()

fun main() {
  val ip = with(client) {
    newCall(Request.Builder().url(API).build()).execute().use { response ->
      if (!response.isSuccessful) throw IOException("Unexpected code $response")

      response.body!!.string()
    }
  }.let {
    Json.decodeFromString<IPAPIResponseDTO>(it)
  }

  println(ip)
}

