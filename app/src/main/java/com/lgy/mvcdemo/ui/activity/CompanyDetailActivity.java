package com.lgy.mvcdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.bean.CompanyDataBean;
import com.lgy.mvcdemo.listener.BuildHeadListener;
import com.lgy.mvcdemo.net.api.SearchCompanyHttpParam;
import com.lgy.mvcdemo.net.model.resp.SearchCompanyResp;
import com.lgy.mvcdemo.utils.StringUtils;
import com.lgy.mvcdemo.view.AddCompanyHeadView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/24.
 */

public class CompanyDetailActivity extends BaseActivity {

    SearchCompanyHttpParam searchCompanyHttpParam;
    @BindView(R.id.view_base_infor)
    AddCompanyHeadView viewBaseInfor;
    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;
    @BindView(R.id.tv_contact_phone)
    TextView tvContactPhone;
    @BindView(R.id.tv_contact_person)
    TextView tvContactPerson;
    @BindView(R.id.tv_companyCredit)
    TextView tvCompanyCredit;
    @BindView(R.id.tv_company_tax)
    TextView tvCompanyTax;
    @BindView(R.id.tv_legal_phone)
    TextView tvLegalPhone;
    @BindView(R.id.tv_industry)
    TextView tvIndustry;
    @BindView(R.id.tv_economicType)
    TextView tvEconomicType;
    @BindView(R.id.tv_legalPerson)
    TextView tvLegalPerson;
    @BindView(R.id.tv_headPerson)
    TextView tvHeadPerson;
    @BindView(R.id.tv_company_type)
    TextView tvCompanyType;
    @BindView(R.id.tv_regAddress)
    TextView tvRegAddress;
    @BindView(R.id.tv_listed_type)
    TextView tvListedType;
    @BindView(R.id.tv_regMoney)
    TextView tvRegMoney;
    @BindView(R.id.ll_base_infor)
    LinearLayout llBaseInfor;
    @BindView(R.id.view_business_license)
    AddCompanyHeadView viewBusinessLicense;
    @BindView(R.id.tv_company_license)
    TextView tvCompanyLicense;
    @BindView(R.id.view_location_infor)
    AddCompanyHeadView viewLocationInfor;
    @BindView(R.id.tv_buildname)
    TextView tvBuildname;
    @BindView(R.id.tv_companyArea)
    TextView tvCompanyArea;
    @BindView(R.id.tv_floorNo)
    TextView tvFloorNo;
    @BindView(R.id.tv_roomNo)
    TextView tvRoomNo;
    @BindView(R.id.tv_part_no)
    TextView tvPartNo;
    @BindView(R.id.tv_seatNo)
    TextView tvSeatNo;
    @BindView(R.id.tv_buildNo)
    TextView tvBuildNo;
    @BindView(R.id.tv_businessNo)
    TextView tvBusinessNo;
    @BindView(R.id.tv_community)
    TextView tvCommunity;
    @BindView(R.id.tv_sliceName)
    TextView tvSliceName;
    @BindView(R.id.ll_lication)
    LinearLayout llLication;
    @BindView(R.id.view_other_license)
    AddCompanyHeadView viewOtherLicense;
    @BindView(R.id.tv_roomMaster)
    TextView tvRoomMaster;
    @BindView(R.id.tv_product_type)
    TextView tvProductType;
    @BindView(R.id.tv_employNum)
    TextView tvEmployNum;
    @BindView(R.id.tv_emptyAccount)
    TextView tvEmptyAccount;
    @BindView(R.id.tv_taxAgency)
    TextView tvTaxAgency;
    @BindView(R.id.tv_inTime)
    TextView tvInTime;
    @BindView(R.id.tv_monthRent)
    TextView tvMonthRent;
    @BindView(R.id.ll_qita_infor)
    LinearLayout llQitaInfor;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    @BindView(R.id.ll_license)
    LinearLayout llLicense;
    private List<CompanyDataBean> industryList = new ArrayList<>();//行业数据

    private List<CompanyDataBean> isEmptyList = new ArrayList<>();//是否空挂户

    private List<CompanyDataBean> productTypeList = new ArrayList<>();//产业类型

    private List<CompanyDataBean> companyTypeList = new ArrayList<>();//企业类型

    private List<CompanyDataBean> listedTypeList = new ArrayList<>();//上市类型

    @Override
    public int getContentViewId() {
        return R.layout.activity_company_detail;
    }

    @Override
    public void bindEventListener() {
        super.bindEventListener();
        viewBaseInfor.setBuildHeadListener(new BuildHeadListener() {
            @Override
            public void buildClickListener(boolean isClcik) {
                setVisibleAndGo(llBaseInfor, isClcik);
            }
        });
        viewBusinessLicense.setBuildHeadListener(new BuildHeadListener() {
            @Override
            public void buildClickListener(boolean isClcik) {
                setVisibleAndGo(llLicense, isClcik);
            }
        });
        viewLocationInfor.setBuildHeadListener(new BuildHeadListener() {
            @Override
            public void buildClickListener(boolean isClcik) {
                setVisibleAndGo(llLication, isClcik);
            }
        });
        viewOtherLicense.setBuildHeadListener(new BuildHeadListener() {
            @Override
            public void buildClickListener(boolean isClcik) {
                setVisibleAndGo(llQitaInfor, isClcik);
            }
        });

    }

    @Override
    public void initData() {
        super.initData();
        /*行业数据*/
        industryList.clear();
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
        isEmptyList.clear();
        isEmptyList.add(new CompanyDataBean("否", "0"));
        isEmptyList.add(new CompanyDataBean("是", "1"));
        /*产业类型*/
        productTypeList.clear();
        productTypeList.add(new CompanyDataBean("第一产业", "第一产业"));
        productTypeList.add(new CompanyDataBean("第二产业", "第二产业"));
        productTypeList.add(new CompanyDataBean("第三产业", "第三产业"));
        /*公司类型*/
        companyTypeList.clear();
        companyTypeList.add(new CompanyDataBean("世界500强", "A"));
        companyTypeList.add(new CompanyDataBean("国内500强", "B"));
        companyTypeList.add(new CompanyDataBean("省内500强", "C"));
        /*上市类型*/
        listedTypeList.clear();
        listedTypeList.add(new CompanyDataBean("主板上市企业", "A"));
        listedTypeList.add(new CompanyDataBean("新三板上市企业", "B"));
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        SearchCompanyResp.CompanyListBean companyListBean = (SearchCompanyResp.CompanyListBean) extras.getSerializable(SearchCompanyResp.CompanyListBean.class.getName());
        SearchCompanyResp.CompanyListBean.BasicEntityBean basicEntity = companyListBean.getBasicEntity();
        SearchCompanyResp.CompanyListBean.OtherEntityBean otherEntity = companyListBean.getOtherEntity();
        SearchCompanyResp.CompanyListBean.PlaceEntityBean placeEntity = companyListBean.getPlaceEntity();
        tvCompanyName.setText(basicEntity.getCompanyName());

        tvContactPhone.setText(basicEntity.getContactPhone());

        tvContactPerson.setText(basicEntity.getContactPerson());

        tvCompanyCredit.setText(basicEntity.getCompanyCredit());

        tvCompanyTax.setText(basicEntity.getCompanyTax());

        tvLegalPhone.setText(basicEntity.getLegalPhone());

        tvIndustry.setText(getIndustry(basicEntity.getIndustry()));

        tvEconomicType.setText(basicEntity.getEconomicType());

        tvLegalPerson.setText(basicEntity.getLegalPerson());

        tvHeadPerson.setText(basicEntity.getHeadPerson());

        tvCompanyType.setText(getCompanyType(basicEntity.getCompanyType()));

        tvRegAddress.setText(basicEntity.getRegAddress());

        tvListedType.setText(getListedType(basicEntity.getListedType()));

        tvRegMoney.setText(basicEntity.getRegMoney());


        tvCompanyLicense.setText(basicEntity.getCompanyLicense());


        tvBuildname.setText(placeEntity.getBuildName());

        tvCompanyArea.setText(placeEntity.getCompanyArea());

        tvFloorNo.setText(placeEntity.getFloorNo());

        tvRoomNo.setText(placeEntity.getRoomNo());

        tvCommunity.setText(placeEntity.getCommunity());

        tvSliceName.setText(placeEntity.getSliceName());

        tvRoomMaster.setText(otherEntity.getRoomMaster());

        tvProductType.setText(getProductType(otherEntity.getProductType()));

        tvEmployNum.setText(otherEntity.getEmployNum());

        tvEmptyAccount.setText(isEmpty(otherEntity.getEmptyAccount()));

        tvTaxAgency.setText(otherEntity.getTaxAgency());

        tvInTime.setText(otherEntity.getInTime());

        tvMonthRent.setText(otherEntity.getMonthRent());

        /**
         * 座号设置
         */
        tvSeatNo.setEnabled(true);
        tvBuildNo.setEnabled(true);
        tvBusinessNo.setEnabled(true);
        tvSeatNo.setSelected(false);
        tvBuildNo.setSelected(false);
        tvBusinessNo.setSelected(false);
        if (!StringUtils.isEmpty(placeEntity.getSeatNo())) {
            tvPartNo.setText(placeEntity.getSeatNo());
            tvSeatNo.setEnabled(false);
            tvSeatNo.setSelected(true);
        } else if (!StringUtils.isEmpty(placeEntity.getBuildNo())) {
            tvPartNo.setText(placeEntity.getBuildNo());
            tvBuildNo.setEnabled(false);
            tvBuildNo.setSelected(true);
        } else if (!StringUtils.isEmpty(placeEntity.getBusinessNo())) {
            tvPartNo.setText(placeEntity.getBusinessNo());
            tvBusinessNo.setEnabled(false);
            tvBusinessNo.setSelected(true);
        }


    }

    public void setVisibleAndGo(View view, boolean isVisiable) {
        if (!isVisiable) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    /**
     * 行业数据查询
     *
     * @param value
     * @return
     */
    public String getIndustry(String value) {
        for (int i = 0; i < industryList.size(); i++) {
            if (industryList.get(i).getValue().equals(value)) {
                return industryList.get(i).getName();
            }
        }
        return "";
    }

    /**
     * 行业数据查询
     *
     * @param value
     * @return
     */
    public String isEmpty(String value) {
        for (int i = 0; i < isEmptyList.size(); i++) {
            if (isEmptyList.get(i).getValue().equals(value)) {
                return isEmptyList.get(i).getName();
            }
        }
        return "";
    }

    /**
     * 行业数据查询
     *
     * @param value
     * @return
     */
    public String getProductType(String value) {
        for (int i = 0; i < productTypeList.size(); i++) {
            if (productTypeList.get(i).getValue().equals(value)) {
                return productTypeList.get(i).getName();
            }
        }
        return "";
    }

    /**
     * 行业数据查询
     *
     * @param value
     * @return
     */
    public String getCompanyType(String value) {
        for (int i = 0; i < companyTypeList.size(); i++) {
            if (companyTypeList.get(i).getValue().equals(value)) {
                return companyTypeList.get(i).getName();
            }
        }
        return "";
    }

    /**
     * 行业数据查询
     *
     * @param value
     * @return
     */
    public String getListedType(String value) {
        for (int i = 0; i < listedTypeList.size(); i++) {
            if (listedTypeList.get(i).getValue().equals(value)) {
                return listedTypeList.get(i).getName();
            }
        }
        return "";
    }
}
