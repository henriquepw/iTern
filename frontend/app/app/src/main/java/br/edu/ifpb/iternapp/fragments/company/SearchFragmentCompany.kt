package br.edu.ifpb.iternapp.fragments.company

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.adapters.StudentAdapter
import br.edu.ifpb.iternapp.conection.Server
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragmentCompany : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    @SuppressLint("CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Server.service.getStudentByCompany(Server.userID)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ students ->
                    val s = students as ArrayList
                    list.adapter = StudentAdapter(students = s, activity = activity!!)
                }, { err ->
                    Server.toask(activity!!, "Erro: ${err.message}")
                })

        list.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
    }

}
