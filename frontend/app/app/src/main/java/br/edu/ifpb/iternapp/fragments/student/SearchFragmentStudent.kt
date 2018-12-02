package br.edu.ifpb.iternapp.fragments.student

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupMenu

import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.adapters.VacancyAdapter
import br.edu.ifpb.iternapp.conection.Server
import br.edu.ifpb.iternapp.entities.Vacancy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragmentStudent : Fragment() {

    private val typeSearch = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        updateVacancys()

        list.layoutManager = LinearLayoutManager(activity!!, LinearLayout.VERTICAL, false)
    }

    @SuppressLint("CheckResult")
    fun updateVacancys(){
        val vacancys = ArrayList<Vacancy>()
        val servise = Server.service

        servise.getAllVacancyNoRegister(Server.userID)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    vacancys.clear()
                    vacancys.addAll(it)
                    list.adapter = VacancyAdapter(vacancys, activity=activity!!)
                }, { err ->
                    Server.toask(activity!!, "Erro ${err.message}")
                })
    }
}

