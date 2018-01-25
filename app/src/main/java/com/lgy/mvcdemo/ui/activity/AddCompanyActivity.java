package com.lgy.mvcdemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.bean.CompanyDataBean;
import com.lgy.mvcdemo.listener.SelectContentListener;
import com.lgy.mvcdemo.view.AddCompanyHeadView;
import com.lgy.mvcdemo.view.pop.SelectContentPop;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/24.
 */

public class AddCompanyActivity extends BaseActivity implements SelectContentListener {
    private final static int INDUSTRY_CODE = 1000;//行业数据

    private final static int BUILDNO_CODE = 1001;//楼宇编号数据

    private final static int ISEMPTY_CODE = 1002;//是否空挂户

    private final static int PRODUCT_CODE = 1003;//产业类型

    private final static int COMPANYTYPE_CODE = 1004;//企业类型

    private final static int LISTEDTYPE_CODE = 1005;//上市类型

    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;
    @BindView(R.id.tv_industry)
    TextView tvIndustry;
    @BindView(R.id.tv_company_type)
    EditText tvCompanyType;
    @BindView(R.id.tv_listed_type)
    TextView tvListedType;
    @BindView(R.id.tv_product_type)
    TextView tvProductType;
    @BindView(R.id.tv_isempty)
    TextView tvIsempty;
    @BindView(R.id.view_base_infor)
    AddCompanyHeadView viewBaseInfor;
    @BindView(R.id.tv_company_no)
    EditText tvCompanyNo;
    @BindView(R.id.ll_base_infor)
    LinearLayout llBaseInfor;
    @BindView(R.id.view_business_license)
    AddCompanyHeadView viewBusinessLicense;
    @BindView(R.id.ll_license)
    LinearLayout llLicense;
    @BindView(R.id.view_location_infor)
    AddCompanyHeadView viewLocationInfor;
    @BindView(R.id.ll_lication)
    LinearLayout llLication;
    @BindView(R.id.view_other_license)
    AddCompanyHeadView viewOtherLicense;
    @BindView(R.id.ll_qita_infor)
    LinearLayout llQitaInfor;
    private SelectContentPop industryContentPop;//行业数据

    private SelectContentPop buildNoContentPop;//楼宇编号数据

    private SelectContentPop isEmptyContentPop;//是否空挂户

    private SelectContentPop productContentPop;//产业类型

    private SelectContentPop companyTypeContentPop;//企业类型

    private SelectContentPop listedTypeContentPop;//上市类型


    private List<CompanyDataBean> industryList = new ArrayList<>();//行业数据

    private List<CompanyDataBean> buildNoList = new ArrayList<>();//楼宇编号数据

    private List<CompanyDataBean> isEmptyList = new ArrayList<>();//是否空挂户

    private List<CompanyDataBean> productTypeList = new ArrayList<>();//产业类型

    private List<CompanyDataBean> companyTypeList = new ArrayList<>();//企业类型

    private List<CompanyDataBean> listedTypeList = new ArrayList<>();//上市类型

    @Override
    public int getContentViewId() {
        return R.layout.activity_add_company;
    }

    @Override
    protected void initView() {
        super.initView();


    }

    @Override
    public void initData() {
        super.initData();
        /*楼号数据添加*/
        buildNoList.add(new CompanyDataBean("座号", "seatNo"));
        buildNoList.add(new CompanyDataBean("楼号", "buildNo"));
        buildNoList.add(new CompanyDataBean("商业区", "businessNo"));
        /*行业数据*/
        industryList.add(new CompanyDataBean("农、林、牧、渔业", "A"));
        industryList.add(new CompanyDataBean("采矿业", "B"));
        industryList.add(new CompanyDataBean("制造业", "C"));
        industryList.add(new CompanyDataBean("电力、热力、燃气及水生产和供应业", "D"));
        industryList.add(new CompanyDataBean("建筑业", "E"));
        industryList.add(new CompanyDataBean("批发和零售业", "F"));
        industryList.add(new CompanyDataBean("交通运输、仓储和邮政业", "G"));
        industryList.add(new CompanyDataBean("住宿和餐饮业", "H"));
        industryList.add(new CompanyDataBean("信息传输、软件和信息技术服务业", "I"));
        industryList.add(new CompanyDataBean("金融业", "J"));
        industryList.add(new CompanyDataBean("房地产业", "K"));
        industryList.add(new CompanyDataBean("租赁和商务服务业", "L"));
        industryList.add(new CompanyDataBean("科学研究和技术服务业", "M"));
        industryList.add(new CompanyDataBean("水利、环境和公共设施管理业", "N"));
        industryList.add(new CompanyDataBean("居民服务、修理和其他服务业", "O"));
        industryList.add(new CompanyDataBean("教育", "P"));
        industryList.add(new CompanyDataBean("卫生和社会工作", "Q"));
        industryList.add(new CompanyDataBean("文化、体育和娱乐业", "R"));
        industryList.add(new CompanyDataBean("公共管理、社会保障和社会组织", "S"));
        industryList.add(new CompanyDataBean("国际组织", "T"));
        /*是否挂空户*/
        isEmptyList.add(new CompanyDataBean("否", "0"));
        isEmptyList.add(new CompanyDataBean("是", "1"));
        /*产业类型*/
        productTypeList.add(new CompanyDataBean("第一产业", "第一产业"));
        productTypeList.add(new CompanyDataBean("第二产业", "第二产业"));
        productTypeList.add(new CompanyDataBean("第三产业", "第三产业"));
        /*公司类型*/
        companyTypeList.add(new CompanyDataBean("世界500强", "A"));
        companyTypeList.add(new CompanyDataBean("国内500强", "B"));
        companyTypeList.add(new CompanyDataBean("省内500强", "C"));
        /*上市类型*/
        listedTypeList.add(new CompanyDataBean("主板上市企业", "A"));
        listedTypeList.add(new CompanyDataBean("新三板上市企业", "B"));
        industryContentPop = new SelectContentPop(this, INDUSTRY_CODE, buildNoList, this);
        buildNoContentPop = new SelectContentPop(this, BUILDNO_CODE, industryList, this);
        isEmptyContentPop = new SelectContentPop(this, ISEMPTY_CODE, isEmptyList, this);
        productContentPop = new SelectContentPop(this, PRODUCT_CODE, productTypeList, this);
        companyTypeContentPop = new SelectContentPop(this, COMPANYTYPE_CODE, companyTypeList, this);
        listedTypeContentPop = new SelectContentPop(this, LISTEDTYPE_CODE, listedTypeList, this);
    }

    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {

    }


    @OnClick({R.id.view_base_infor, R.id.tv_company_name, R.id.tv_industry, R.id.tv_company_type, R.id.tv_listed_type, R.id.view_business_license, R.id.view_location_infor, R.id.view_other_license, R.id.tv_product_type, R.id.tv_isempty, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_company_name:
                industryContentPop.showPopupWindow();
                break;
            case R.id.tv_industry:
                industryContentPop.showPopupWindow();
                break;
            case R.id.tv_company_type:
                companyTypeContentPop.showPopupWindow();
                break;
            case R.id.tv_listed_type:
                listedTypeContentPop.showPopupWindow();
                break;
            case R.id.tv_product_type:
                productContentPop.showPopupWindow();
                break;
            case R.id.tv_isempty:
                isEmptyContentPop.showPopupWindow();
                break;
            case R.id.view_base_infor:
                boolean expand = viewBaseInfor.getExpand();
                if (!expand) {
                    llBaseInfor.setVisibility(View.VISIBLE);
                } else {
                    llBaseInfor.setVisibility(View.GONE);
                }
                break;
            case R.id.view_business_license:
                break;
            case R.id.view_location_infor:
                break;
            case R.id.view_other_license:
                break;
            case R.id.btn_confirm:
                break;
        }
    }


    @Override
    public void onSelectSuccess(int code, CompanyDataBean companyDataBean) {
        switch (code) {
            case INDUSTRY_CODE:
                tvIndustry.setText(companyDataBean.getName());
                break;
            case BUILDNO_CODE:
                tvCompanyName.setText(companyDataBean.getName());
                break;
            case ISEMPTY_CODE:
                tvIsempty.setText(companyDataBean.getName());
                break;
            case PRODUCT_CODE:
                tvProductType.setText(companyDataBean.getName());
                break;
            case COMPANYTYPE_CODE:
                tvCompanyType.setText(companyDataBean.getName());
                break;
            case LISTEDTYPE_CODE:
                tvListedType.setText(companyDataBean.getName());
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
