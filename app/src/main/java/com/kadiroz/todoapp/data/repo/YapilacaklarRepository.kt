package com.kadiroz.todoapp.data.repo

import com.kadiroz.todoapp.data.datasource.YapilacaklarDataSource
import com.kadiroz.todoapp.data.entity.Yapilacaklar

class YapilacaklarRepository(var yds: YapilacaklarDataSource) {


    suspend fun kaydet(yapilacak_baslik:String, yapilacak_aciklama:String) = yds.kaydet(yapilacak_baslik, yapilacak_aciklama)

    suspend fun  guncelle(yapilacak_id:Int,yapilacak_baslik:String, yapilacak_aciklama:String) =  yds.guncelle(yapilacak_id,yapilacak_baslik,yapilacak_aciklama )

    suspend fun  sil(yapilacak_id:Int) = yds.sil(yapilacak_id)

    suspend fun  yapilacaklariYukle() : List<Yapilacaklar> = yds.yapilacaklariYukle()

    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar> = yds.ara(aramaKelimesi)
}