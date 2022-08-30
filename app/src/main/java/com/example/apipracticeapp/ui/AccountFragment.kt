package com.example.apipracticeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apipracticeapp.R
import com.example.apipracticeapp.databinding.FragmentAccountBinding
import com.example.apipracticeapp.databinding.FragmentRankingBinding

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }
}