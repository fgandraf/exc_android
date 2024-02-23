package com.felipegandra.meuscontatos.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.felipegandra.meuscontatos.model.Contato

@Dao
interface ContatoDao {

    @Insert
    fun salvar(contato: Contato) : Long

    @Update
    fun atualizar(contato: Contato) : Int

    @Delete
    fun excluir(contato: Contato) : Int

    @Query(value = "SELECT * FROM tbl_contato WHERE id = :id")
    fun buscarContatoPeloId(id: Long) : Contato

    @Query(value = "SELECT * FROM tbl_contato ORDER BY nome ASC")
    fun listarContatos() : List<Contato>


}