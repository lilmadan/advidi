package com.advidi.demo.affiliate

import com.advidi.demo.common.FileExtractor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/affiliate")
class AffiliateController {

    @Autowired
    lateinit var repository: AffiliateRepository

    @RequestMapping("/init")
    fun initializeValues() : Boolean {
        var resource: Resource = ClassPathResource("static/affiliate.csv")
        val extractedData = FileExtractor().readFromCSV(resource.file.absolutePath, "affiliate")
        return AffiliateService().bulkInsert(extractedData, repository)
    }

     @RequestMapping("/save")
    fun process(): String{
        repository.save(Affiliate(1, "Jack", "Smith"))
        repository.save(Affiliate(2, "Adam", "Johnson"))
        repository.save(Affiliate(3, "Kim", "Smith"))
        repository.save(Affiliate(4, "David", "Williams"))
        repository.save(Affiliate(5, "Peter", "Davis"))
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
    fun fetchDataByLastName(@RequestParam("lastname") lastName: String): String{
        var result = ""

        for(cust in repository.findByLastName(lastName)){
            result += cust.toString() + "</br>"
        }

        return result
    }
}