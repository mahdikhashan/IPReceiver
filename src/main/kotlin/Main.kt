package org.example

import kotlinx.serialization.json.Json
import org.example.client.OKHTTPWrapper
import org.example.model.IPAPIResponseDTO

private const val API = "https://api.ipify.org?format=json"

fun main() {
  val ip = OKHTTPWrapper.get(API)
    .let {
    Json.decodeFromString<IPAPIResponseDTO>(it)
  }

  println(ip)
}

