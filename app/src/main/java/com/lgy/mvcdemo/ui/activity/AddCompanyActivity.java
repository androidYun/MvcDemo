package com.lgy.mvcdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.bean.CompanyDataBean;
import com.lgy.mvcdemo.event.SearchBuildEvent;
import com.lgy.mvcdemo.listener.BuildHeadListener;
import com.lgy.mvcdemo.listener.SelectContentListener;
import com.lgy.mvcdemo.net.api.AddCompanyHttpParam;
import com.lgy.mvcdemo.utils.TimeUtils;
import com.lgy.mvcdemo.view.AddCompanyHeadView;
import com.lgy.mvcdemo.view.pop.SelectContentPop;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.lgy.mvcdemo.R.id.tv_seatNo;

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
    @BindView(R.id.tv_industry)
    TextView tvIndustry;
    @BindView(R.id.tv_company_type)
    EditText tvCompanyType;
    @BindView(R.id.tv_listed_type)
    TextView tvListedType;
    @BindView(R.id.tv_product_type)
    TextView tvProductType;
    @BindView(R.id.view_base_infor)
    AddCompanyHeadView viewBaseInfor;
    @BindView(R.id.tv_company_no)
    TextView tvCompanyNo;
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
    @BindView(R.id.ev_company_name)
    EditText evCompanyName;
    @BindView(R.id.ev_contact_phone)
    EditText evContactPhone;
    @BindView(R.id.ev_contact_person)
    EditText evContactPerson;
    @BindView(R.id.ev_company_tax)
    EditText evCompanyTax;
    @BindView(R.id.ev_legal_phone)
    EditText evLegalPhone;
    @BindView(R.id.ev_company_license)
    EditText evCompanyLicense;
    @BindView(R.id.tv_buildname)
    TextView tvBuildname;
    @BindView(R.id.ev_companyArea)
    EditText evCompanyArea;
    @BindView(R.id.ev_part_no)
    EditText evPartNo;
    @BindView(R.id.ev_floorNo)
    EditText evFloorNo;
    @BindView(R.id.ev_roomNo)
    EditText evRoomNo;
    @BindView(R.id.ev_community)
    EditText evCommunity;
    @BindView(R.id.ev_companyCredit)
    EditText evCompanyCredit;
    @BindView(R.id.ev_economicType)
    EditText evEconomicType;
    @BindView(R.id.ev_legalPerson)
    EditText evLegalPerson;
    @BindView(R.id.ev_headPerson)
    EditText evHeadPerson;
    @BindView(R.id.ev_regAddress)
    EditText evRegAddress;
    @BindView(R.id.ev_regMoney)
    EditText evRegMoney;
    @BindView(R.id.ev_sliceName)
    EditText evSliceName;
    @BindView(R.id.ev_roomMaster)
    EditText evRoomMaster;
    @BindView(R.id.ev_employNum)
    EditText evEmployNum;
    @BindView(R.id.tv_emptyAccount)
    TextView tvEmptyAccount;
    @BindView(R.id.ev_taxAgency)
    EditText evTaxAgency;
    @BindView(R.id.tv_inTime)
    TextView tvInTime;
    @BindView(R.id.ev_monthRent)
    EditText evMonthRent;
    @BindView(tv_seatNo)
    TextView tvSeatNo;
    @BindView(R.id.tv_buildNo)
    TextView tvBuildNo;
    @BindView(R.id.tv_businessNo)
    TextView tvBusinessNo;
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

    private AddCompanyHttpParam addCompanyHttpParam;

    private TimePickerView pvCustomTime;

    private String selectPart;//分区选择

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_add_company;
    }

    @Override
    protected void initView() {
        super.initView();
        addCompanyHttpParam = new AddCompanyHttpParam();
        initCustomTimePicker();
        tvSeatNo.setSelected(true);
        selectPart = "seatNo";
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

    @OnClick({R.id.tv_buildname, R.id.tv_company_no, R.id.tv_industry, R.id.tv_company_type, R.id.tv_listed_type, R.id.tv_product_type, R.id.tv_emptyAccount, R.id.btn_confirm, R.id.tv_inTime, tv_seatNo, R.id.tv_buildNo, R.id.tv_businessNo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_company_no:
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
            case R.id.tv_emptyAccount:
                isEmptyContentPop.showPopupWindow();
                break;
            case R.id.btn_confirm:
                setPostParam();
                break;
            case R.id.tv_inTime:
                pvCustomTime.show();
                break;
            case R.id.tv_buildname:
                startActivity(new Intent(this, SearchBuildActivity.class));
                break;
            case tv_seatNo:
                selectComunty(tvSeatNo);
                selectPart = "seatNo";
                break;
            case R.id.tv_buildNo:
                selectComunty(tvBuildNo);
                selectPart = "buildNo";
                break;
            case R.id.tv_businessNo:
                selectComunty(tvBusinessNo);
                selectPart = "businessNo";
                break;
        }
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
    public void onSelectSuccess(int code, CompanyDataBean companyDataBean) {
        switch (code) {
            case INDUSTRY_CODE:
                tvIndustry.setText(companyDataBean.getName());
                addCompanyHttpParam.industry = companyDataBean.getValue();
                break;
            case BUILDNO_CODE:
                tvCompanyNo.setText(companyDataBean.getName());
                addCompanyHttpParam.buildNo = companyDataBean.getValue();
                break;
            case ISEMPTY_CODE:
                tvEmptyAccount.setText(companyDataBean.getName());
                addCompanyHttpParam.emptyAccount = companyDataBean.getValue();
                break;
            case PRODUCT_CODE:
                tvProductType.setText(companyDataBean.getName());
                addCompanyHttpParam.productType = companyDataBean.getValue();
                break;
            case COMPANYTYPE_CODE:
                tvCompanyType.setText(companyDataBean.getName());
                addCompanyHttpParam.companyType = companyDataBean.getValue();
                break;
            case LISTEDTYPE_CODE:
                tvListedType.setText(companyDataBean.getName());
                addCompanyHttpParam.listedType = companyDataBean.getValue();
                break;

        }
    }

    private void initCustomTimePicker() {

        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(1990, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局
        pvCustomTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                String time = TimeUtils.getTime(date);
                tvInTime.setText(time);
                addCompanyHttpParam.inTime = time;//24
            }
        }).setDate(selectedDate)
                    .setRangDate(startDate, endDate)
                    .setLayoutRes(R.layout.dialog_select_date, new CustomListener() {

                        @Override
                        public void customLayout(View v) {
                            final TextView tvConfirm = (TextView) v.findViewById(R.id.tv_confirm);
                            TextView tvCancle = (TextView) v.findViewById(R.id.tv_cancle);
                            tvConfirm.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    pvCustomTime.returnData();
                                    pvCustomTime.dismiss();
                                }
                            });
                            tvCancle.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    pvCustomTime.dismiss();
                                }
                            });
                        }
                    })
                    .setContentSize(18)
                    .setType(new boolean[]{true, true, true, false, false, false})
                    .setLabel("年", "月", "日", "时", "分", "秒")
                    .setLineSpacingMultiplier(1.2f)
                    .setTextXOffset(0, 0, 0, 40, 0, -40)
                    .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                    .setDividerColor(0xFF24AD9D)
                    .build();
    }

    public void setVisibleAndGo(View view, boolean isVisiable) {
        if (!isVisiable) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    public void setPostParam() {
        addCompanyHttpParam.buildName = tvBuildname.getText().toString();//1
        addCompanyHttpParam.community = evCommunity.getText().toString();//2
        addCompanyHttpParam.companyArea = evCompanyArea.getText().toString();//3
        addCompanyHttpParam.companyLicense = evCompanyLicense.getText().toString();//4
        addCompanyHttpParam.companyName = evCompanyName.getText().toString();//5
        addCompanyHttpParam.companyTax = evCompanyTax.getText().toString().trim();//6
        addCompanyHttpParam.contactPerson = evContactPerson.getText().toString();//7
        addCompanyHttpParam.contactPhone = evContactPhone.getText().toString();//8
        addCompanyHttpParam.economicType = evEconomicType.getText().toString();//9
        addCompanyHttpParam.employNum = evEmployNum.getText().toString();//10
        addCompanyHttpParam.floorNo = evFloorNo.getText().toString();//11
        addCompanyHttpParam.legalPhone = evLegalPhone.getText().toString();//12
        addCompanyHttpParam.legalPerson = evLegalPerson.getText().toString();//13
        addCompanyHttpParam.headPerson = evHeadPerson.getText().toString();//14
        addCompanyHttpParam.contactPerson = evContactPerson.getText().toString();//15
        addCompanyHttpParam.roomMaster = evRoomMaster.getText().toString();//16
        addCompanyHttpParam.monthRent = evMonthRent.getText().toString();//17
        addCompanyHttpParam.regAddress = evRegAddress.getText().toString();//18
        addCompanyHttpParam.roomNo = evRoomNo.getText().toString();//19
        addCompanyHttpParam.seatNo = evSliceName.getText().toString();//20
        addCompanyHttpParam.taxAgency = evTaxAgency.getText().toString();//21
        addCompanyHttpParam.companyCredit = evCompanyCredit.getText().toString();//23
        addCompanyHttpParam.seatNo = "";
        addCompanyHttpParam.businessNo = "";
        addCompanyHttpParam.buildNo = "";
        if (selectPart.equals("seatNo")) {
            addCompanyHttpParam.seatNo = evPartNo.getText().toString().trim();
        } else if (selectPart.equals("businessNo")) {
            addCompanyHttpParam.businessNo = evPartNo.getText().toString().trim();
        } else {
            addCompanyHttpParam.buildNo = evPartNo.getText().toString().trim();
        }
        httpManger.doPostHttp(addCompanyHttpParam);

    }

    public void selectComunty(View view) {
        tvSeatNo.setEnabled(true);
        tvBuildNo.setEnabled(true);
        tvBusinessNo.setEnabled(true);
        tvSeatNo.setSelected(false);
        tvBuildNo.setSelected(false);
        tvBusinessNo.setSelected(false);
        view.setEnabled(false);
        view.setSelected(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SearchBuildEvent event) {
        addCompanyHttpParam.buildName = event.getBuildName().toString().trim();
        tvBuildname.setText(event.getBuildName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
