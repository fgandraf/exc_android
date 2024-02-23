package com.felipegandra.meuscontatos.database.repository

import android.content.Context
import com.felipegandra.meuscontatos.database.dao.ContatoDb
import com.felipegandra.meuscontatos.model.Contato

class ContatoRepository(context: Context) {
    private var db = ContatoDb.getDatabase(context).contatoDao()

    fun salvar(contato: Contato):Long{
        return db.salvar(contato)
    }

    fun atualizar(contato: Contato):Int{
        return db.atualizar(contato)
    }

    fun excluir(contato:Contato):Int{
        return db.excluir(contato)
    }

    fun buscarContatoPeloIf(id: Long): Contato{
        return db.buscarContatoPeloId(id)
    }

    fun listarContatos(): List<Contato>{
        return db.listarContatos()
    }



}