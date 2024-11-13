package com.lion.a061ex_roomdatabase.viewmodel

import AnimalType

data class AnimalViewModel(
    var animalIdx:Int,
    var animalType:AnimalType,
    var animalName:String,
    var animalAge:Int,
    var animalGender:String,
    var animalFavoriteSnack:String)