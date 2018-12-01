package br.edu.ifpb.iternapp.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.entities.Student

class StudentAdapter(
        private val students: ArrayList<Student>,
        private val type: Boolean = true,
        private val activity: Activity) : RecyclerView.Adapter<StudentAdapter.Holder>() {

    private var dialog: AlertDialog? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.list_item_student, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    private fun removeItem(student: Student){
        var pos = students.indexOf(student)
        students.remove(student)
        notifyItemRemoved(pos)
    }

    @SuppressLint("InflateParams", "SetTextI18n")
    override fun onBindViewHolder(p0: Holder, p1: Int) {
        val student = students[p1]
        p0.name.text = student.name


        p0.bt.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            //val view = activity.layoutInflater.inflate(R.layout.dialog_student, null)

            // Exibir dados do aluno

            //builder.setView(view)
            dialog = builder.create()
            dialog?.show()
        }

    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.txVancacy)!!
        val bt = view.findViewById<RelativeLayout>(R.id.bt)!!
    }
}