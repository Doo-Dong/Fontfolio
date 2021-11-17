package com.corporation8793.fontfolio.library.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Font_Data.xls 의 2행(row) 단위 중 [Font.fontStyleInformation]열(column)을 [Entity]로 사용하기 위한 데이터 클래스.
 * @author  두동근
 * @see     [androidx.room.Entity]
 * @see     [Font]
 */
@Entity
data class FontStyleInformation(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "Original") val Original : Boolean = false,
    @ColumnInfo(name = "Normal") val Normal : Boolean = false,
)