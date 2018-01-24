package com.lgy.mvcdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lgy.mvcdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/24.
 */

public class AddCompanyHeadView extends RelativeLayout {
    @BindView(R.id.iv_modify_head)
    ImageView ivModifyHead;
    @BindView(R.id.rl_modify_head)
    RelativeLayout rlModifyHead;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private Context mContext;

    private int leftResId;

    private String title;

    private View inflateView;//加载的布局

    public AddCompanyHeadView(Context context) {
        super(context);
        this.mContext = context;
        initView(context);
        inflateView();
    }


    public AddCompanyHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NaviTitleView);
        leftResId = typedArray.getResourceId(R.styleable.AddCompanyHeadView_head_left_res, R.mipmap.btn_back);
        title = typedArray.getString(R.styleable.AddCompanyHeadView_head_title);
        typedArray.recycle();
        initView(context);
        inflateView();
    }

    private void initView(Context context) {
        this.mContext = context;
        inflateView = LayoutInflater.from(context).inflate(R.layout.view_add_company, this, true);
        ButterKnife.bind(this, inflateView);
    }

    private void inflateView() {
        ivModifyHead.setImageResource(leftResId);
        tvTitle.setText(title);
    }
}
