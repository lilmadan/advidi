package com.advidi.demo.offer

import java.lang.Exception

class OfferService {

    public fun bulkInsert(offers: MutableList<Any>, repository: OfferRepository): Boolean {
        return try {
            if(offers.isNotEmpty()) {
                val iterate = offers.listIterator()
                // This is used just for a beginning insert
                var count : Int = repository.count().toInt();
                var entities = mutableListOf<Offer>()
                while (iterate.hasNext()) {
                    count += 1
                    val offer = iterate.next() as Offer
                    offer.rowId = count
                    println(offer)
                    entities.add(offer)
                }
                repository.saveAll(entities)
            }
            true;
        }catch (e : Exception) {
            println("Offer Exception $e")
            false;
        }

    }
}