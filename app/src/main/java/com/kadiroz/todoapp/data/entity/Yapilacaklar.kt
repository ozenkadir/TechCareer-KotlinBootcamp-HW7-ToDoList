package com.kadiroz.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "yapilacaklar")
data class Yapilacaklar(@PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name = "yapilacak_id") @NotNull var yapilacak_id:Int,
                        @ColumnInfo(name = "yapilacak_baslik") @NotNull var yapilacak_baslik:String,
                        @ColumnInfo(name = "yapilacak_aciklama") @NotNull var yapilacak_aciklama:String): Serializable{

}
