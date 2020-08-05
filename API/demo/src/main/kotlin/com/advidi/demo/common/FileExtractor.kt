package com.advidi.demo.common

import com.advidi.demo.affiliate.Affiliate
import mu.KotlinLogging
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import java.nio.file.Files
import java.nio.file.Paths

public class FileExtractor {
    val logger = KotlinLogging.logger {}

    public fun readFromCSV (CSV_File_Path: String, entity: String): MutableList<Any>  {
       logger.debug { "Extracting File -> $CSV_File_Path" }
        val dataList: MutableList<Any> = mutableListOf()
        try {
            val reader = Files.newBufferedReader(Paths.get(CSV_File_Path))
            val csvParser = CSVParser(reader, CSVFormat.DEFAULT)
            var columnList = mutableListOf<String>()

            for (csvRecord in csvParser) {
                // Accessing Values by Column Index
                println("Record No - " + csvRecord.recordNumber)
                println(csvRecord)
                // Re-Assigning. Just in case
                columnList = mutableListOf<String>()
                when  {
                    // Clip off Headers
                    (csvRecord.recordNumber > 1) -> {
                        for (recordColumn: Int in 0 until csvRecord.size()) {
                            columnList.add(csvRecord.get(recordColumn))
                        }
                    }
                }
                if(columnList.size > 0 ) {
                    println(columnList)
                    dataList.add(CommonFactory().getModel(entity, columnList.toTypedArray()))
                }
                println(" - ${csvRecord.size()}")
            }
        } catch (e: Exception) {
            println("Reader Exception $e")
        } finally {
            return dataList
        }
    }
}