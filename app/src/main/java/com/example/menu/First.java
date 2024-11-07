package com.example.menu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class First extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        view.setBackgroundResource(R.color.blue);
        textView = view.findViewById(R.id.text_view);
        registerForContextMenu(textView);
        return view;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = requireActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.change_text1) {
            textView.setText("вау");
            return true;
        }
        if (item.getItemId() == R.id.change_text2) {
            textView.setText("ура");
            return true;
        }
        if (item.getItemId() == R.id.change_text3) {
            textView.setText("победа");
            return true;
        }
        else {
            return super.onContextItemSelected(item);
        }
    }
}

