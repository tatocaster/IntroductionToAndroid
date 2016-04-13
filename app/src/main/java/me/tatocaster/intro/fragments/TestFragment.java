package me.tatocaster.intro.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import me.tatocaster.intro.R;
import me.tatocaster.intro.interfaces.IOnButtonClickListener;

/**
 * Created by tatocaster on 4/13/16.
 */
public class TestFragment extends Fragment {
    public static final String TAG = "TestFragment";
    private Button mButton;
    private IOnButtonClickListener mIOnButtonClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View mView = inflater.inflate(R.layout.fragment_main, container, false);
        mButton = (Button) mView.findViewById(R.id.fragment_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mView.getContext(), "Here", Toast.LENGTH_SHORT).show();
                mIOnButtonClickListener.onButtonClick(v);
            }
        });
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IOnButtonClickListener) {
            mIOnButtonClickListener = (IOnButtonClickListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implemenet " + IOnButtonClickListener.class.getSimpleName());
        }
    }
}
