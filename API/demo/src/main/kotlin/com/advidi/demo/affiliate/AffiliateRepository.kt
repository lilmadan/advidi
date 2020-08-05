package com.advidi.demo.affiliate

import org.springframework.data.repository.CrudRepository

interface AffiliateRepository: CrudRepository<Affiliate, Long>{
    fun findByLastName(lastName: String): List<Affiliate>
}