package com.example.livestockmanagement.ui.cattle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.livestockmanagement.databinding.FragmentCattleBinding;

public class CattleFragment extends Fragment {

    private FragmentCattleBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CattleViewModel cattleViewModel =
                new ViewModelProvider(this).get(CattleViewModel.class);

        binding = FragmentCattleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCattle;
        cattleViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
