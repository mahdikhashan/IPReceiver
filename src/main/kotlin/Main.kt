package org.example

import kotlinx.serialization.json.Json
import org.example.client.httpClient
import org.example.model.IPAPIResponseDTO

private const val API = "https://api.ipify.org?format=json"

fun main() {
  val ip = httpClient.get(API).let {
    Json.decodeFromString<IPAPIResponseDTO>(it)
  }

  println(ip)
}

