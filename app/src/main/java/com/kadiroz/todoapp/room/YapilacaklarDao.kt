package com.kadiroz.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kadiroz.todoapp.data.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun yapilacakalariYukle() : List<Yapilacaklar>

    @Insert
    suspend fun kaydet(yapilacak:Yapilacaklar)

    @Update
    suspend fun guncelle(yapilacak: Yapilacaklar)

    @Delete
    suspend fun sil(yapilacak: Yapilacaklar)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_baslik like '%' || :aramaKelimesi || '%' ")
    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar>
}