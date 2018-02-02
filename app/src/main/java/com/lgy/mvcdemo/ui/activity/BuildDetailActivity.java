package com.lgy.mvcdemo.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.bean.CompanyDataBean;
import com.lgy.mvcdemo.listener.BuildHeadListener;
import com.lgy.mvcdemo.net.api.SearchBuildHttpParam;
import com.lgy.mvcdemo.net.model.resp.BuildDetailResp;
import com.lgy.mvcdemo.utils.FastJsonUtil;
import com.lgy.mvcdemo.view.AddCompanyHeadView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${lgy} on 2018/2/214:09
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class BuildDetailActivity extends BaseActivity {

    @BindView(R.id.view_base_infor)
    AddCompanyHeadView viewBaseInfor;
    @BindView(R.id.tv_aboveparkingnum)
    TextView tvAboveparkingnum;
    @BindView(R.id.tv_allFloor)
    TextView tvAllFloor;
    @BindView(R.id.tv_autoliftNum)
    TextView tvAutoliftNum;
    @BindView(R.id.tv_floorArea)
    TextView tvFloorArea;
    @BindView(R.id.tv_goodliftNum)
    TextView tvGoodliftNum;
    @BindView(R.id.tv_buildArea)
    TextView tvBuildArea;
    @BindView(R.id.tv_buildType)
    TextView tvBuildType;
    @BindView(R.id.tv_personliftNum)
    TextView tvPersonliftNum;
    @BindView(R.id.tv_merchantArea)
    TextView tvMerchantArea;
    @BindView(R.id.tv_businessArea)
    TextView tvBusinessArea;
    @BindView(R.id.tv_buildUnit)
    TextView tvBuildUnit;
    @BindView(R.id.tv_underparkingArea)
    TextView tvUnderparkingArea;
    @BindView(R.id.tv_underparkingNum)
    TextView tvUnderparkingNum;
    @BindView(R.id.tv_usetime)
    TextView tvUsetime;
    @BindView(R.id.tv_coverArea)
    TextView tvCoverArea;
    SearchBuildHttpParam searchBuildHttpParam;
    @BindView(R.id.ll_base_infor)
    LinearLayout llBaseInfor;
    @BindView(R.id.view_place)
    AddCompanyHeadView viewPlace;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_buildName)
    TextView tvBuildName;
    @BindView(R.id.tv_sliceName)
    TextView tvSliceName;
    @BindView(R.id.tv_lat)
    TextView tvLat;
    @BindView(R.id.tv_lng)
    TextView tvLng;
    @BindView(R.id.tv_community)
    TextView tvCommunity;
    @BindView(R.id.ll_place)
    LinearLayout llPlace;
    @BindView(R.id.view_property)
    AddCompanyHeadView viewProperty;
    @BindView(R.id.tv_propertyMoney)
    TextView tvPropertyMoney;
    @BindView(R.id.tv_propertyPerson)
    TextView tvPropertyPerson;
    @BindView(R.id.tv_propertyPhone)
    TextView tvPropertyPhone;
    @BindView(R.id.tv_propertyUnit)
    TextView tvPropertyUnit;
    @BindView(R.id.ll_property)
    LinearLayout llProperty;
    @BindView(R.id.view_server)
    AddCompanyHeadView viewServer;
    @BindView(R.id.tv_propertyFacilities)
    TextView tvPropertyFacilities;
    @BindView(R.id.tv_propertyHealth)
    TextView tvPropertyHealth;
    @BindView(R.id.tv_propertyNice)
    TextView tvPropertyNice;
    @BindView(R.id.tv_propertySecurity)
    TextView tvPropertySecurity;
    @BindView(R.id.ll_server)
    LinearLayout llServer;
    @BindView(R.id.view_suit)
    AddCompanyHeadView viewSuit;
    @BindView(R.id.tv_frameCulture)
    TextView tvFrameCulture;
    @BindView(R.id.tv_frameEducation)
    TextView tvFrameEducation;
    @BindView(R.id.tv_frameFinancial)
    TextView tvFrameFinancial;
    @BindView(R.id.tv_frameFood)
    TextView tvFrameFood;
    @BindView(R.id.tv_frameTraffic)
    TextView tvFrameTraffic;
    @BindView(R.id.ll_suit)
    LinearLayout llSuit;
    @BindView(R.id.view_work)
    AddCompanyHeadView viewWork;
    @BindView(R.id.tv_BA)
    TextView tvBA;
    @BindView(R.id.tv_CA)
    TextView tvCA;
    @BindView(R.id.tv_FA)
    TextView tvFA;
    @BindView(R.id.tv_OA)
    TextView tvOA;
    @BindView(R.id.tv_SA)
    TextView tvSA;
    @BindView(R.id.ll_work)
    LinearLayout llWork;
    private List<CompanyDataBean> industryList = new ArrayList<>();//行业数据

    @Override
    public int getContentViewId() {
        return R.layout.activity_build_detail;
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
        viewPlace.setBuildHeadListener(new BuildHeadListener() {
            @Override
            public void buildClickListener(boolean isClcik) {
                setVisibleAndGo(llPlace, isClcik);
            }
        });
        viewProperty.setBuildHeadListener(new BuildHeadListener() {
            @Override
            public void buildClickListener(boolean isClcik) {
                setVisibleAndGo(llProperty, isClcik);
            }
        });
        viewServer.setBuildHeadListener(new BuildHeadListener() {
            @Override
            public void buildClickListener(boolean isClcik) {
                setVisibleAndGo(llServer, isClcik);
            }
        });
        viewSuit.setBuildHeadListener(new BuildHeadListener() {
            @Override
            public void buildClickListener(boolean isClcik) {
                setVisibleAndGo(llSuit, isClcik);
            }
        });
        viewWork.setBuildHeadListener(new BuildHeadListener() {
            @Override
            public void buildClickListener(boolean isClcik) {
                setVisibleAndGo(llWork, isClcik);
            }
        });

    }
    @Override
    public void initData() {
        super.initData();
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
        Intent intent = getIntent();
        String buildname = intent.getStringExtra("buildname");
        searchBuildHttpParam = new SearchBuildHttpParam();
        searchBuildHttpParam.buildName = buildname;
        httpManger.doPostHttp(searchBuildHttpParam);
    }

    @Override
    public void onSuccess(int command, String result) {
        super.onSuccess(command, result);
        if (command == searchBuildHttpParam.getCommand()) {
            BuildDetailResp buildDetailResp = FastJsonUtil.getObject(result, BuildDetailResp.class);
            if (buildDetailResp.buildList != null && buildDetailResp.buildList.size() > 0) {
                inflateView(buildDetailResp);
            }
        }
    }

    public void inflateView(BuildDetailResp buildDetailResp) {
        BuildDetailResp.BuildListBean buildListBean = buildDetailResp.buildList.get(0);
        BuildDetailResp.BuildListBean.BasicEntityBean basicEntity = buildListBean.basicEntity;
        BuildDetailResp.BuildListBean.PlaceEntityBean placeEntity = buildListBean.placeEntity;
        BuildDetailResp.BuildListBean.PropertyEntityBean propertyEntity = buildListBean.propertyEntity;
        BuildDetailResp.BuildListBean.ServerEntityBean serverEntity = buildListBean.serverEntity;
        BuildDetailResp.BuildListBean.SuitEntityBean suitEntity = buildListBean.suitEntity;
        BuildDetailResp.BuildListBean.WorkEntityBean workEntity = buildListBean.workEntity;
        tvAboveparkingnum.setText(basicEntity.aboveparkingNum + "");
        tvAllFloor.setText(basicEntity.allFloor + "");
        tvAutoliftNum.setText(basicEntity.autoliftNum + "");
        tvFloorArea.setText(basicEntity.floorArea + "");
        tvGoodliftNum.setText(basicEntity.goodliftNum + "");
        tvBuildArea.setText(basicEntity.buildArea + "");
        tvBuildType.setText(getIndustry(basicEntity.buildType) + "");
        tvPersonliftNum.setText(basicEntity.personliftNum + "");
        tvMerchantArea.setText(basicEntity.merchantArea + "");
        tvBusinessArea.setText(basicEntity.businessArea + "");
        tvBuildUnit.setText(basicEntity.buildUnit + "");
        tvUnderparkingArea.setText(basicEntity.underparkingArea + "");
        tvUnderparkingNum.setText(basicEntity.underparkingNum + "");
        tvUsetime.setText(basicEntity.usetime + "");
        tvCoverArea.setText(basicEntity.coverArea + "");
        /*位置信息*/

        tvAddress.setText(placeEntity.address + "");
        tvBuildName.setText(placeEntity.buildName + "");
        tvSliceName.setText(placeEntity.sliceName + "");
        tvLat.setText(placeEntity.lat + "");
        tvLng.setText(placeEntity.lng + "");
        tvCommunity.setText(placeEntity.community + "");
        /*物业信息*/
        tvPropertyMoney.setText(propertyEntity.propertyMoney + "");
        tvPropertyPerson.setText(propertyEntity.propertyPerson + "");
        tvPropertyPhone.setText(propertyEntity.propertyPhone + "");
        tvPropertyUnit.setText(propertyEntity.propertyUnit + "");
        /*服务水平*/
        tvPropertyFacilities.setText(serverEntity.propertyFacilities + "");
        tvPropertyHealth.setText(serverEntity.propertyHealth + "");
        tvPropertyNice.setText(serverEntity.propertyNice + "");
        tvPropertySecurity.setText(serverEntity.propertySecurity + "");
          /*配套环境*/
        tvFrameCulture.setText(suitEntity.frameCulture + "");
        tvFrameEducation.setText(suitEntity.frameEducation + "");
        tvFrameFinancial.setText(suitEntity.frameFinancial + "");
        tvFrameFood.setText(suitEntity.frameFood + "");
        tvFrameTraffic.setText(suitEntity.frameTraffic + "");
            /*办公环境*/
        tvBA.setText(workEntity.BA + "");
        tvCA.setText(workEntity.CA + "");
        tvFA.setText(workEntity.FA + "");
        tvOA.setText(workEntity.OA + "");
        tvSA.setText(workEntity.SA + "");
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


    public void setVisibleAndGo(View view, boolean isVisiable) {
        if (!isVisiable) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

}
