package com.lion.a061ex_roomdatabase.repository

import AnimalType
import android.content.Context
import com.lion.a061ex_roomdatabase.viewmodel.AnimalViewModel
import com.lion.team1_project.dao.AnimalDatabase
import com.lion.team1_project.vo.AnimalVO

class AnimalRepository {

    companion object{

        // 동물 정보를 저장하는 메서드
        fun insertAnimalInfo(context: Context, animalViewModel: AnimalViewModel){
            // 데이터베이스 객체를 가져온다.
            val animalDatabase = AnimalDatabase.getInstance(context)
            // ViewModel에 있는 데이터를 VO에 담아준다.
            val animalType = animalViewModel.animalType.number
            val animalName = animalViewModel.animalName
            val animalAge = animalViewModel.animalAge
            val animalGender = animalViewModel.animalGender
            val animalFavoriteSnack = animalViewModel.animalFavoriteSnack

            val animalVO = AnimalVO(animalType = animalType, animalName = animalName, animalAge = animalAge, animalGender = animalGender, animalFavoriteSnack = animalFavoriteSnack)

            animalDatabase?.animalDAO()?.insertAnimalData(animalVO)
        }

        // 동물 정보 전체를 가져오는 메서드
        fun selectAnimalInfoAll(context: Context) : MutableList<AnimalViewModel>{
            // 데이터 베이스 객체
            val animalDatabase = AnimalDatabase.getInstance(context)
            // 동물 데이터 전체를 가져온다
            val animalVoList = animalDatabase?.animalDAO()?.selectAnimalDataAll()
            // 동물 데이터를 담을 리스트
            val animalViewModelList = mutableListOf<AnimalViewModel>()
            // 동물의 수 만큼 반복한다.
            animalVoList?.forEach {
                // 동물 데이터를 추출한다.
                val animalType = when(it.animalType){
                    AnimalType.Animal_TYPE_DOG.number -> AnimalType.Animal_TYPE_DOG
                    AnimalType.Animal_TYPE_CAT.number -> AnimalType.Animal_TYPE_CAT
                    else -> AnimalType.Animal_TYPE_PARROT
                }
                val animalName = it.animalName
                val animalAge = it.animalAge
                val animalIdx = it.animalIdx
                val animalGender = it.animalGender
                val animalFavoriteSnack = it.animalFavoriteSnack

                // 객체에 담는다.
                val animalViewModel = AnimalViewModel(animalIdx, animalType, animalName, animalAge, animalGender, animalFavoriteSnack)
                // 리스트에 담는다.
                animalViewModelList.add(animalViewModel)
            }
            return animalViewModelList
        }
    }
}