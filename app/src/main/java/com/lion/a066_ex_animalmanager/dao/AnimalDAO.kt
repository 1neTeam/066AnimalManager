package com.lion.team1_project.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lion.team1_project.vo.AnimalVO

@Dao
interface AnimalDAO {

    // 동물 정보 저장
    @Insert
    fun insertAnimalData(animalVO: AnimalVO)

    // 동물 정보를 가져오는 메서드
    @Query("""
        select * from AnimalTable 
        order by animalIdx desc""")
    fun selectAnimalDataAll() : List<AnimalVO>
}
