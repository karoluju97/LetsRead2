package ie.wit.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ie.wit.R

class LetsReadFragement : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, scontainer: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        val root = inflater.inflate(R.layout.fragment_lets_read, scontainer, false)
        activity?.title = getString(R.string.action_home)

        return root;
    }

    companion object{
        @JvmStatic
        fun newInstance() =
            LetsReadFragement().apply {
                arguments = Bundle().apply {}
            }
    }

}
