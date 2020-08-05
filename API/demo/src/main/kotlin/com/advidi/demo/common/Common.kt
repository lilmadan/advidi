package com.advidi.demo.common

import com.advidi.demo.affiliate.Affiliate
import com.advidi.demo.affiliate.AffiliateService
import com.advidi.demo.offer.Offer
import mu.KotlinLogging

class CommonFactory {
    val logger = KotlinLogging.logger {}
    fun getFileExtractor() : FileExtractor{
        return FileExtractor()
    }

    fun getModel (modelName: String, vararg params: Any): Any {
        when {
            modelName.equals("affiliate") -> return Affiliate(params)
            modelName.equals("offer") -> return Offer(params)
            else -> return null!!
        }
    }
}
