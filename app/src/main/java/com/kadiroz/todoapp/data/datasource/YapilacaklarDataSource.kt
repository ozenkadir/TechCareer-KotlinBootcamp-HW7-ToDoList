package com.kadiroz.todoapp.data.datasource

import android.util.Log
import com.kadiroz.todoapp.data.entity.Yapilacaklar
import com.kadiroz.todoapp.room.YapilacaklarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacaklarDataSource(var ydao:YapilacaklarDao) {
    suspend fun kaydet(yapilacak_baslik:String, yapilacak_aciklama:String){
        val yeniYapilacak = Yapilacaklar(0,yapilacak_baslik,yapilacak_aciklama)
        ydao.kaydet(yeniYapilacak)
    }

    suspend fun guncelle(yapilacak_id:Int,yapilacak_baslik:String, yapilacak_aciklama:String) {
        val guncellenenYapilacak = Yapilacaklar(yapilacak_id,yapilacak_baslik,yapilacak_aciklama)
        ydao.guncelle(guncellenenYapilacak)
    }

   suspend fun sil(yapilacak_id:Int){
       val silinenYapilacak = Yapilacaklar(yapilacak_id,"","")
       ydao.sil(silinenYapilacak)
   }

    suspend fun yapilacaklariYukle() : List<Yapilacaklar> =
        withContext(Dispatchers.IO) {

        return@withContext ydao.yapilacakalariYukle()
    }

    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar> =
        withContext(Dispatchers.IO) {
            return@withContext ydao.ara(aramaKelimesi)
    }
}