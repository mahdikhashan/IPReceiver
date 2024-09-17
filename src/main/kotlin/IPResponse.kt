package org.example

import kotlinx.serialization.Serializable

@Serializable
data class IPAPIResponse(val ip: String) {
  override fun toString() = ip
}