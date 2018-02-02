package com.lgy.mvcdemo.net.api;

import com.lgy.mvcdemo.net.api.base.BaseHttpParam;
import com.lgy.mvcdemo.net.model.LegalParam;
import com.lgy.mvcdemo.utils.StringUtils;
import com.lzy.okgo.model.HttpMethod;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/23.
 *
 * 新增企业（command=4）
 请求方式：POST
 */

public class AddCompanyHttpParam extends BaseHttpParam {

    public String buildName;//楼宇名称

    public String seatNo;//座号

    public String buildNo;//楼号

    public String businessNo;//商业区

    public String community;//社区

    public String companyArea;//公司面积

    public String industry;//行业A 农、林、牧、渔业； B 采矿业； C 制造业； D 电力、热力、燃气及水生产和供应业； E 建筑业； F 批发和零售业； G 交通运输、仓储和邮政业； H 住宿和餐饮业； I 信息传输、软件和信息技术服务业； J 金融业； K 房地产业； L 租赁和商务服务业； M 科学研究和技术服务业； N 水利、环境和公共设施管理业； O 居民服务、修理和其他服务业； P 教育； Q 卫生和社会工作； R 文化、体育和娱乐业； S 公共管理、社会保障和社会组织； T 国际组织

    public String companyName;//公司名称

    public String companyLicense;//营业执照

    public String companyTax;//税务登记证

    public String companyCredit;//统一信用代码

    public String regAddress;//注册地址

    public String economicType;//经济性质

    public String legalPerson;//法人

    public String headPerson;//负责人

    public String legalPhone;//负责人电话  法人电话

    public String taxAgency;//纳税机构

    public String emptyAccount;//是否空挂户  0:否 1:是

    public String productType;//产业类型

    public String inTime;//入驻时间

    public String roomMaster;//房屋产权单位

    public String floorNo;//所在楼层

    public String roomNo;//所在房间

    public String employNum;//员工人数

    public String monthRent;//(元/m2/月)

    public String companyType;//企业类型   固定取值：A: 世界500强B: 国内500强C: 省内500强

    public String listedType;//上市类型

    public String contactPerson;//联系人

    public String contactPhone;//联系电话


    public AddCompanyHttpParam() {
        super();
        setHttpMethod(HttpMethod.POST);
        setCommand(4);
        setNeekToken(false);
        setNeedProgress(true);
    }

    @Override
    public HashMap<String, String> getParamMap() {
        paramMap.put("buildName",buildName);
        paramMap.put("seatNo",seatNo);
        paramMap.put("buildNo",buildNo);
        paramMap.put("businessNo",businessNo);
        paramMap.put("companyArea",companyArea);
        paramMap.put("industry",industry);
        paramMap.put("community",community);
        paramMap.put("companyName",companyName);
        paramMap.put("companyLicense",companyLicense);
        paramMap.put("companyTax",companyTax);
        paramMap.put("companyCredit",companyCredit);
        paramMap.put("regAddress",regAddress);
        paramMap.put("economicType",economicType);
        paramMap.put("legalPerson",legalPerson);
        paramMap.put("headPerson",headPerson);
        paramMap.put("legalPhone",legalPhone);
        paramMap.put("taxAgency",taxAgency);
        paramMap.put("emptyAccount",emptyAccount);
        paramMap.put("productType",productType);
        paramMap.put("inTime",inTime);
        paramMap.put("roomMaster",roomMaster);
        paramMap.put("floorNo",floorNo);
        paramMap.put("roomNo",roomNo);
        paramMap.put("employNum",employNum);
        paramMap.put("monthRent",monthRent);
        paramMap.put("companyType",companyType);
        paramMap.put("listedType",listedType);
        paramMap.put("contactPerson",contactPerson);
        paramMap.put("contactPhone",contactPhone);
        return paramMap;
    }

    @Override
    public LegalParam isParamLegal() {
        if (StringUtils.isEmpty(buildName)) {
            legalParam.setErrorMsg("楼宇名称不能为空");
            return legalParam;
        }
//        if (StringUtils.isEmpty(passWord)) {
//            legalParam.setErrorMsg("密码不能为空");
//            return legalParam;
//        }
        legalParam.setLegal(true);
        return legalParam;
    }
}
