package com.corporation8793.fontfolio.library.room.dao

import androidx.room.*
import com.corporation8793.fontfolio.library.room.entity.font.Font
import com.corporation8793.fontfolio.library.room.entity.qna.Question

/**
 * [Question]의 [Dao].
 * @author  두동근
 * @see     Question
 * @see     androidx.room.RoomDatabase
 * @see     androidx.room.Dao
 */
@Dao
interface QuestionDao {
    /**
     * 모든 [Question]를 [List]로 반환합니다.
     * @author  두동근
     * @return  List<Question>
     */
    @Query("SELECT * FROM question")
    fun getAll() : List<Question>

    /**
     * [RoomDatabase]에 [Question]를 [Insert]합니다.
     * @author  두동근
     * @param   question  [Question]의 인스턴스
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg question : Question)

    /**
     * [RoomDatabase]에 [Question]를 [Update]합니다.
     * @author  두동근
     * @param   question  [Question]의 인스턴스
     */
    @Update
    fun update(vararg question : Question)
}