package com.guamaninga.myapplication.data.entities

data class Users (
    var id: Int,
    var userName: String,
    var password: String
){
    constructor(nombre: String,
                apellido: String,
                perfil: String): this(0, "", "")

    constructor():this(0,"","")
}

// nombre,  apellido, perfil

// constructor vacio
