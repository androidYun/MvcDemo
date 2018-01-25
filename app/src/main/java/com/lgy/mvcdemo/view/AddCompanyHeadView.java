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
import com.lgy.mvcdemo.listener.BuildHeadListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.iv_expand)
    ImageView ivExpand;
    private Context mContext;

    private int leftResId;

    private String title;

    private View inflateView;//加载的布局

    private BuildHeadListener buildHeadListener;

    public AddCompanyHeadView(Context context) {
        super(context);
        this.mContext = context;
        initView(context);
        inflateView();
    }


    public AddCompanyHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AddCompanyHeadView);
        leftResId = typedArray.getResourceId(R.styleable.AddCompanyHeadView_head_left_res, 0);
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
        if (leftResId != 0) {
            ivModifyHead.setImageResource(leftResId);
        }
        tvTitle.setText(title);
    }

    @OnClick(R.id.rl_modify_head)
    public void onViewClicked() {
        buildHeadListener.buildClickListener(ivExpand.isSelected());
        if (ivExpand.isSelected()) {
            ivExpand.setSelected(false);
            ivModifyHead.setSelected(false);
        } else {
            ivExpand.setSelected(true);
            ivModifyHead.setSelected(true);
        }
    }

    /**
     * 获取项目是否是展开状态
     *
     * @return
     */
    public boolean getExpand() {
        return ivExpand.isSelected();
    }


    public void setBuildHeadListener(BuildHeadListener buildHeadListener) {
        this.buildHeadListener = buildHeadListener;
    }
}
