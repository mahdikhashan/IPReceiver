package org.example.model

import kotlinx.serialization.Serializable

@Serializable
data class IPAPIResponseDTO(val ip: String) {
  override fun toString() = ip
}

