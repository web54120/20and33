package com.searoth.template.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.searoth.template.R

class SecondFragment : Fragment() {

    // สิ่งที่ต้องทำ: เปลี่ยนชื่อและเปลี่ยนประเภทของพารามิเตอร์
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // ขยายเลย์เอาต์พุตสำหรับแฟรกเมนต์นี้
        return inflater!!.inflate(R.layout.fragment_second, container, false)
    }

    // สิ่งที่ต้องทำ: เปลี่ยนชื่อเมธอดอัปเดตอาร์กิวเมนต์และเมธอด เป็นเหตุการณ์ UI
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }


    interface OnFragmentInteractionListener {
        //สิ่งที่ต้องทำ: อัปเดตประเภท
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        //สิ่งที่ต้องทำ: เปลี่ยนชื่ออาร์กิวเมนต์พารามิเตอร์เลือกชื่อที่ตรงกัน
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        // สิ่งที่ต้องทำ: เปลี่ยนชื่อและเปลี่ยนประเภทและจำนวนพารามิเตอร์
        fun newInstance(param1: String, param2: String): SecondFragment {
            val fragment = SecondFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
