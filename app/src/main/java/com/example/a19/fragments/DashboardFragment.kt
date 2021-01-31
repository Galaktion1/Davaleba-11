package com.example.a19.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.a19.MainActivity
import com.example.a19.PasswordChangeActivity
import com.example.a19.R
import com.google.firebase.auth.FirebaseAuth

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {
    private lateinit var pInfoTextView: TextView
    private lateinit var passwordChangeButton: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var logOutButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth= FirebaseAuth.getInstance()
        pInfoTextView= view.findViewById(R.id.textView)
        passwordChangeButton = view.findViewById(R.id.timeToChangePassword)
        logOutButton = view.findViewById(R.id.logOutMan)

        pInfoTextView.text=mAuth.currentUser?.uid
        passwordChangeButton.setOnClickListener{
            activity?.startActivity(Intent(activity, PasswordChangeActivity::class.java))

        }
        logOutButton.setOnClickListener{
            mAuth.signOut()
            activity?.startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()
        }
    }
}