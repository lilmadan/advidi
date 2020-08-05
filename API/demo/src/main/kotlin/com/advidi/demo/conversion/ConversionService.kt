package com.advidi.demo.conversion

import java.lang.Exception

class ConversionService {

    public fun bulkInsert(affiliates: MutableList<Any>, repository: ConversionRepository): Boolean {
        return try {
            if(affiliates.isNotEmpty()) {
                val iterate = affiliates.listIterator()
                // This is used just for a beginning insert
                var count : Int = repository.count().toInt();
                var entities = mutableListOf<Conversion>()
                while (iterate.hasNext()) {
                    count += 1
                    val affiliate = iterate.next() as Conversion
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