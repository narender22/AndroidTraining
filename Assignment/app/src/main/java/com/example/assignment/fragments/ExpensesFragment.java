package com.example.assignment.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.AddExpense;
import com.example.assignment.AddIncome;
import com.example.assignment.DataModel;
import com.example.assignment.LoginActivity;
import com.example.assignment.MyDbHelper;
import com.example.assignment.R;
import com.example.assignment.RecyclerDataAdapter;

import java.util.ArrayList;

public class ExpensesFragment extends Fragment {

    public ExpensesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyDbHelper dbHelper = new MyDbHelper(getActivity());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expenses, container, false);
//        create instance for views used
        Button incomeButton = view.findViewById(R.id.addIncome);
        Button expenseButton = view.findViewById(R.id.addExpense);
        TextView income = view.findViewById(R.id.income);
        TextView expense = view.findViewById(R.id.expense);
        Button logout = view.findViewById(R.id.logout);


//        recycler view
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
//        set linear layout
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        arraylist to store data about categories
        ArrayList<DataModel> arrayData = new ArrayList<>();
        RecyclerDataAdapter adapter;
//        to show the total income
        income.setText(String.valueOf(dbHelper.getCategoryTotal("Income")));
//        show total expense
        expense.setText(String.valueOf(dbHelper.getTotal()));

//        pass data to show in RecyclerView
        arrayData.add(new DataModel(R.drawable.ic_check_box_blue, "Food", dbHelper.getCategoryTotal("Food")));
        arrayData.add(new DataModel(R.drawable.ic_check_box_bluedark, "Investment", dbHelper.getCategoryTotal("Investment")));
        arrayData.add(new DataModel(R.drawable.ic_check_box_green, "Family", dbHelper.getCategoryTotal("Family")));
        arrayData.add(new DataModel(R.drawable.ic_check_box_purple, "Daily Necessities", dbHelper.getCategoryTotal("Daily Necessities")));
        arrayData.add(new DataModel(R.drawable.ic_check_box_raddish, "Debt & Loan", dbHelper.getCategoryTotal("Debt & Loan")));
        arrayData.add(new DataModel(R.drawable.ic_check_box_red, "Budget Balance", dbHelper.getCategoryTotal("Budget Balance")));


//        assign activity and dataset for the adapter
        adapter = new RecyclerDataAdapter(getActivity(), arrayData);
//        set adapter for the recyclerView
        recyclerView.setAdapter(adapter);

//        Add income button is clicked
        incomeButton.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), AddIncome.class);
            startActivity(intent);
        });

//        add expense button is clicked
        expenseButton.setOnClickListener(view1 -> {
//      define an intent
            Intent intent = new Intent(getActivity(), AddExpense.class);
            startActivity(intent);
        });

        logout.setOnClickListener(view1 -> {
            SharedPreferences pref = requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            editor.putBoolean("flag", true);
            editor.apply();

            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });

        return view;
    }
}