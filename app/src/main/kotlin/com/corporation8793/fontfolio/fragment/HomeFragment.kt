package com.corporation8793.fontfolio.fragment

import android.annotation.SuppressLint
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.res.ResourcesCompat.getFont
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.corporation8793.fontfolio.activity.MainActivity
import com.corporation8793.fontfolio.R
import com.corporation8793.fontfolio.common.Fontfolio
import com.corporation8793.fontfolio.dialog.SortByDialog
import com.corporation8793.fontfolio.fragment.search.SearchFragment
import com.corporation8793.fontfolio.library.room.entity.font.Font
import com.corporation8793.fontfolio.recylcerview.FontAdapter
import com.corporation8793.fontfolio.recylcerview.SpacesItemDecoration
import java.lang.RuntimeException

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment(activity : MainActivity) : Fragment() {
    //push 확인
    private var param1: String? = null
    private var param2: String? = null
    lateinit var sort_by_btn: Button
    var mActivity = activity

    lateinit var fontfolio: Fontfolio
    lateinit var font_list: RecyclerView

    val datas = mutableListOf<Font>()
    lateinit var mAdapter:FontAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        Fontfolio.searchFragment = SearchFragment(mActivity, true)

        sort_by_btn = view.findViewById(R.id.sort_by_btn)
        font_list = view.findViewById(R.id.font_list)

        val sortByDialog = SortByDialog()
        mAdapter = FontAdapter(mActivity.applicationContext,activity)

        notifyItem()

        font_list.adapter = mAdapter
        font_list.layoutManager = LinearLayoutManager(context)
        font_list.addItemDecoration(DividerItemDecoration(context,1))


        

        sort_by_btn.setOnClickListener(View.OnClickListener {
            sortByDialog.show(
                mActivity.supportFragmentManager,
                sortByDialog.tag
            )
        })

        return view
    }

    fun notifyItem(){
        datas.clear()
        var count = 0;

        for (i in Fontfolio.list){
            Log.e("fontLicenseDescription",i.fontLicenseDescription)
//            if (!i.fontLicenseDescription.contains("Adobe") ) {

                    try {
                        if (!resources.getFont(resources.getIdentifier(
                        "${i.fontName.toLowerCase().replace("-", "_")
                            .replace(" ", "_")}",
                        "font", activity?.packageName)).toString().equals(0x00000000)) {
                            Log.e("fontname",i.fontName)
                            datas.add(i)
                }
                    }catch (e : RuntimeException){
                        Log.e("폰트","저장 안 되어 있음")
                    }

//                }
                count++
                if (count == 200)
                    break
            }


//        }

        mAdapter.datas = datas
        mAdapter.notifyDataSetChanged()
    }
}