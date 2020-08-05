package com.advidi.demo.conversion

import java.lang.Exception
import java.sql.Date
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "conversion")
public class Conversion(

        @Id
        var rowId: Int = -1,

        @Column(name = "offer_id")
        var offerId: Int = -1,

        @Column(name = "affiliate_id")
        var affiliateId: Int = -1,

        @Column(name = "timestamp")
        var timeStamp: Date = null!!,

        @Column(name = "payout")
        var payout: Double = 0.0,

        @Column(name = "received")
        var received: Double = 0.0

){

    constructor(param: Array<out Any>) : this() {
        if(param.size > 0) {
            val paramValues = param[0] as Array<String>;
            offerId = Integer.parseInt(paramValues[1])
            affiliateId = Integer.parseInt(paramValues[2])
            try {
                timeStamp = LocalDate.parse(paramValues[3], DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) as Date
            } catch (e: Exception) {

            }
            payout = paramValues[4].toDouble()
            received = paramValues[5].toDouble()
        }
    }

    override fun toString(): String{
        return "Conversion[id=${rowId}, offerId=${offerId}, affiliateId=${affiliateId}, timeStamp=${timeStamp} , payout=${payout}, received=${received}]"
    }
}