package com.advidi.demo.offer


import com.advidi.demo.common.FileExtractor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/offer")
class OfferController {

    @Autowired
    lateinit var repository: OfferRepository

    @RequestMapping("/init")
    fun initializeValues() : Boolean {
        var resource: Resource = ClassPathResource("static/offers.csv")
        val extractedData = FileExtractor().readFromCSV(resource.file.absolutePath, "offer")
        return OfferService().bulkInsert(extractedData, repository)
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

    @RequestMapping("/findbylastname")
    fun fetchDataByLastName(@RequestParam("name") name: String): String{
        var result = ""

        for(cust in repository.findByName(name)){
            result += cust.toString() + "</br>"
        }

        return result
    }
}