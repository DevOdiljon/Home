package com.example.fragmentgetargument

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentFirst: Fragment() {
    var KEY:String = "the_key"
    lateinit var fragment:FragmentFirst


    public fun newInstance(str: String):  FragmentFirst{
        if (fragment == null)fragment = (FragmentFirst())
        var bundle = Bundle()
        bundle.putString(KEY, str)

        fragment.arguments = bundle

        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var fragment = inflater.inflate(R.layout.fragment_first, container, false)
        var tv_text = fragment.findViewById<TextView>(R.id.tv_text)
        tv_text.setText(arguments?.getString(KEY))
        return fragment
    }
}