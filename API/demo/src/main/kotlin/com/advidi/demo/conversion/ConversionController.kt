package com.advidi.demo.conversion

import com.advidi.demo.common.FileExtractor
import com.advidi.demo.offer.OfferRepository
import com.advidi.demo.offer.OfferService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/conversion")
class ConversionController {

    @Autowired
    lateinit var repository: ConversionRepository

    @RequestMapping("/init")
    fun initializeValues() : Boolean {
        var resource: Resource = ClassPathResource("static/offers.csv")
        val extractedData = FileExtractor().readFromCSV(resource.file.absolutePath, "offer")
        return ConversionService().bulkInsert(extractedData, repository)
    }

    @RequestMapping("/save")
    fun process(): String{

        return "Done"
    }


    @RequestMapping("/findall")
    fun findAll(): String{
        var result = ""

        for(cust in repository.findAll()){
            result += cust.toString() + "</br>"
        }

        return result
    }

    @RequestMapping("/findbyid")
    fun findById(@RequestParam("id") id: Long): String{
        return repository.findById(id).toString()
    }
}