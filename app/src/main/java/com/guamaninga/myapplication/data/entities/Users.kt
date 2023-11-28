package com.guamaninga.myapplication.data.entities

data class Users (
    var userName: String?=null,
    var password: String?=null
){
    var id: Int = -1
    var firstName: String = "nombre sin registrar"
    var lastName: String = "apellido sin registar"
    var profile: String = "perfil vacio"

    constructor(userName: String?, password: String?, id: Int,firstName:String, lastName:String)
            :this("",""){
                this.id=id
                this.userName=userName
                this.password=password
                this.firstName=firstName
                this.lastName=lastName
            }

    constructor(nombre: String,
                apellido: String,
                perfil: String): this("", "")

    constructor():this("","")
}

// nombre,  apellido, perfil

// constructor vacio
