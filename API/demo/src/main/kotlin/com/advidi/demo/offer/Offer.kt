package com.advidi.demo.offer
import javax.persistence.*

@Entity
@Table(name = "offer")
public class Offer(
        @Id
        var rowId: Int = -1,

        @Column (name = "id")
        var id: Int = -1,

        @Column (name = "url")
        var url: String = "",

        @Column(name = "name")
        var name: String = ""

){
    constructor(param: Array<out Any>) : this() {
        if(param.size > 0) {
            val paramValues = param[0] as Array<String>;
            id = Integer.parseInt(paramValues[0])
            url = paramValues[1]
            name = paramValues[2]
            println(url)
        }
    }
    override fun toString(): String{
        return "Offer[id=${id}, url=${url}, name=${name}]"
    }
}