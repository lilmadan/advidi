package com.advidi.demo.offer

import org.springframework.data.repository.CrudRepository

interface OfferRepository: CrudRepository<Offer, Long> {
    fun findByName(name: String): List<Offer>
}