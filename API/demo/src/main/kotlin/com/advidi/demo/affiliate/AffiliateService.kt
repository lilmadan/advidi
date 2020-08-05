package com.advidi.demo.affiliate

import java.lang.Exception

class AffiliateService {

    public fun bulkInsert(affiliates: MutableList<Any>, repository: AffiliateRepository): Boolean {
        return try {
            if(affiliates.isNotEmpty()) {
                val iterate = affiliates.listIterator()
                // This is used just for a beginning insert
                var count : Int = repository.count().toInt();
                var entities = mutableListOf<Affiliate>()
                while (iterate.hasNext()) {
                    count += 1
                    val affiliate = iterate.next() as Affiliate
                    affiliate.rowId = count
                    println(affiliate)
                    entities.add(affiliate)
                }
                repository.saveAll(entities)
            }
            true;
        }catch (e : Exception) {
            false;
        }

    }
}