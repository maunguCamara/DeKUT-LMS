package com.example.livestockmanagement.ui.milk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.livestockmanagement.databinding.FragmentMilkBinding;

public class MilkRecordFragment extends Fragment {

    private FragmentMilkBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MilkViewModel milkViewModel =
                new ViewModelProvider(this).get(MilkViewModel.class);

        binding = FragmentMilkBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMilk;
        milkViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
