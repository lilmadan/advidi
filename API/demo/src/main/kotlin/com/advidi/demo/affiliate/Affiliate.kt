package com.advidi.demo.affiliate

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "affiliate")
public class Affiliate(

        @Id
        var rowId: Int = -1,

        @Column(name = "id")
        var id: Int = -1,

        @Column(name = "firstname")
        var company: String = "",

        @Column(name = "lastname")
        var name: String = "",

        vararg val params: String
){

    constructor(param: Array<out Any>) : this() {
        if(param.size > 0) {
            val paramValues = param[0] as Array<String>;
            id = Integer.parseInt(paramValues[0])
            company = paramValues[1]
            name = paramValues[2]
        }
    }

    override fun toString(): String{
        return "Affiliate[id=${id}, company=${company}, name=${name}]"
    }
}