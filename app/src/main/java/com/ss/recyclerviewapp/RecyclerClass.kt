package com.ss.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerClass(var array: ArrayList<DataClass1>) : RecyclerView.Adapter<RecyclerClass.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerClass.ViewHolder {
    var initView = LayoutInflater.from(parent.context).inflate(R.layout.layout1,parent,false)
    return ViewHolder(initView)
    }



    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var tvId = view.findViewById<TextView>(R.id.tvId)
        var tvrollNo = view.findViewById<TextView>(R.id.tvrollNo)
        var tvName = view.findViewById<TextView>(R.id.tvName)

    }
    override fun onBindViewHolder(holder: RecyclerClass.ViewHolder, position: Int) {
     holder.tvId.setText(array.get(position).id.toString())
        holder.tvName.setText(array.get(position).name.toString())
        holder.tvrollNo.setText(array.get(position).rollNo.toString())

    }
    override fun getItemCount(): Int {
   return array.size
    }
}