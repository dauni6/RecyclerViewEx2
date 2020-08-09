package com.dontsu.recyclerviewex2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PersonAdapter(
    val items: ArrayList<Person>,
    private val clickListener: (person: Person) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    //클릭이벤트 같이 넣어주기
    //자바였으면 보통 인터페이스를 만들어서 콜백을 넣어주는데, 코틀린은 매개변수에 함수를 전달할 수 있어서 매개변수를 활용한다. 위 생성자에 clickListener !
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_person_item, parent, false)
        val viewHolder = PersonViewHolder(view)
        view.setOnClickListener {
            clickListener.invoke(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PersonViewHolder) {
            holder.bind(items[position])
        }
    }

    //뷰홀더 : 뷰홀더는 인플레이트된 뷰객체를 갖고 있다.
    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.item_name)
        private val age = view.findViewById<TextView>(R.id.item_age)

        fun bind(person: Person) {
            name.text = person.name
            age.text = person.age.toString()
        }
    }

}
