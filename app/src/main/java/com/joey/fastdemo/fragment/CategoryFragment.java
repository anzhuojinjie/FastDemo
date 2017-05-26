package com.joey.fastdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.classic.common.MultipleStatusView;
import com.joey.fastdemo.R;


/**
 * Created by joey on 2017/4/4.
 */

public class CategoryFragment extends Fragment
{

    private MultipleStatusView mMultipleStatusView;
    Button btnContent,btnLoading,btnEmpty,btnError,btnEx;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catgory,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMultipleStatusView = (MultipleStatusView)view.findViewById(R.id.main_multiplestatusview);
        mMultipleStatusView.setOnRetryClickListener(onRetryClickListener);
        mMultipleStatusView.showLoading();
        btnContent = (Button) view.findViewById(R.id.btnContent);
        btnLoading = (Button) view.findViewById(R.id.btnLoading);
        btnEmpty = (Button) view.findViewById(R.id.btnEmpty);
        btnError = (Button) view.findViewById(R.id.btnError);
        btnEx = (Button) view.findViewById(R.id.btnEx);
        btnContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMultipleStatusView.showContent();
            }
        });
        btnLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMultipleStatusView.showLoading();
            }
        });
        btnEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMultipleStatusView.showEmpty();
            }
        });
        btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMultipleStatusView.showError();
            }
        });
        btnEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMultipleStatusView.showNoNetwork();
            }
        });
    }
    private final View.OnClickListener onRetryClickListener = new View.OnClickListener() {
        @Override public void onClick(View v) {
            Toast.makeText(getContext(), "您点击了重试视图", Toast.LENGTH_SHORT).show();
            mMultipleStatusView.showLoading();
        }
    };

}
