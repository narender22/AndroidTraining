package com.example.assignment.fragments;

import android.content.Intent;
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expenses, container, false);
//        create instance for views used
        Button incomeButton = view.findViewById(R.id.addIncome);
        Button expenseButton = view.findViewById(R.id.addExpense);
        TextView income = view.findViewById(R.id.income);
        TextView expense = view.findViewById(R.id.expense);
//        create variables for categories
        int foodAmount=8621, investmentAmount=5995, familyAmount=895;
        int dailyAmount=594, debtAmount=99, budgetAmount=4204;
        int totalIncome = 20000;
        int totalExpense;
        int i;

//        recycler view
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
//        set linear layout
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        arraylist to store data about
        ArrayList<DataModel> arrayData = new ArrayList<>();
        RecyclerDataAdapter adapter;

        try{
            Bundle bundle = requireActivity().getIntent().getExtras();
            if (bundle.getString("ExpenseCategory") != null) {
                switch (bundle.getString("ExpenseCategory")) {
                    case "Food":
                        i = Integer.parseInt(bundle.getString("ExpenseAmount"));
                        foodAmount = foodAmount + i;
                        break;
                    case "Investment":
                        i = Integer.parseInt(bundle.getString("ExpenseAmount"));
                        investmentAmount = investmentAmount + i;
                        break;
                    case "Family":
                        i = Integer.parseInt(bundle.getString("ExpenseAmount"));
                        familyAmount = familyAmount + i;
                        break;
                    case "Daily Necessities":
                        i = Integer.parseInt(bundle.getString("ExpenseAmount"));
                        dailyAmount = dailyAmount + i;
                        break;
                    case "Debt & Loan":
                        i = Integer.parseInt(bundle.getString("ExpenseAmount"));
                        debtAmount = debtAmount + i;
                        break;
                    default:
                        i = Integer.parseInt(bundle.getString("ExpenseAmount"));
                        budgetAmount = budgetAmount + i;
                        break;
                }
            } else {
                i = Integer.parseInt(bundle.getString("IncomeAmount"));
                totalIncome = totalIncome + i;
            }
        }
        catch (NullPointerException e){
            System.out.println("Catch block executed");
        }

        totalExpense = foodAmount + investmentAmount + familyAmount + dailyAmount + debtAmount + budgetAmount;

        income.setText(String.valueOf(totalIncome));
        expense.setText(String.valueOf(totalExpense));

        arrayData.add(new DataModel(R.drawable.ic_check_box_blue, "Food", String.valueOf(foodAmount)));
        arrayData.add(new DataModel(R.drawable.ic_check_box_bluedark, "Investment", String.valueOf(investmentAmount)));
        arrayData.add(new DataModel(R.drawable.ic_check_box_green, "Family", String.valueOf(familyAmount)));
        arrayData.add(new DataModel(R.drawable.ic_check_box_purple, "Daily Necessities", String.valueOf(dailyAmount)));
        arrayData.add(new DataModel(R.drawable.ic_check_box_raddish, "Debt & Loan", String.valueOf(debtAmount)));
        arrayData.add(new DataModel(R.drawable.ic_check_box_red, "Budget Balance", String.valueOf(budgetAmount)));

        adapter = new RecyclerDataAdapter(getActivity(), arrayData);
        recyclerView.setAdapter(adapter);

//      Bundle to get data


        incomeButton.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), AddIncome.class);
            startActivity(intent);
        });

        expenseButton.setOnClickListener(view1 -> {
//      define an intent
            Intent intent = new Intent(getActivity(), AddExpense.class);
            startActivity(intent);
        });

        return view;
    }
}