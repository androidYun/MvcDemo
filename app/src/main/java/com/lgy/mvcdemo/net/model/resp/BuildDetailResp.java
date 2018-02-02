package com.lgy.mvcdemo.net.model.resp;

import java.util.List;

/**
 * Created by ${lgy} on 2018/2/214:41
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class BuildDetailResp {

    /**
     * command : 6
     * result : 0
     * errorMsg :
     * buildList : [{"basicEntity":{"aboveparkingNum":50,"allFloor":20,"autoliftNum":50,"buildArea":11000,"buildType":"E","buildUnit":"恒大地产","businessArea":8000,"coverArea":12000,"floorArea":200,"goodliftNum":50,"merchantArea":8000,"personliftNum":50,"underparkingArea":1000,"underparkingNum":50,"usetime":"2018-01-25"},"placeEntity":{"address":"郑州市南阳路兴隆铺路","buildName":"清华园","community":"刘寨社区","lat":"0","lng":"0","sliceName":"南阳路街道"},"propertyEntity":{"propertyMoney":"80000.00","propertyPerson":"薛广超","propertyPhone":"18530920798","propertyUnit":"英德物业有限公司"},"serverEntity":{"propertyFacilities":"较完善","propertyHealth":"较完善","propertyNice":"较完善","propertySecurity":"较完善"},"suitEntity":{"frameCulture":"一般","frameEducation":"一般","frameFinancial":"一般","frameFood":"一般","frameTraffic":"一般"},"workEntity":{"BA":"较完善","CA":"较完善","FA":"较完善","OA":"较完善","SA":"较完善"}}]
     */

    public int command;
    public int result;
    public String errorMsg;
    public List<BuildListBean> buildList;

    public static class BuildListBean {
        /**
         * basicEntity : {"aboveparkingNum":50,"allFloor":20,"autoliftNum":50,"buildArea":11000,"buildType":"E","buildUnit":"恒大地产","businessArea":8000,"coverArea":12000,"floorArea":200,"goodliftNum":50,"merchantArea":8000,"personliftNum":50,"underparkingArea":1000,"underparkingNum":50,"usetime":"2018-01-25"}
         * placeEntity : {"address":"郑州市南阳路兴隆铺路","buildName":"清华园","community":"刘寨社区","lat":"0","lng":"0","sliceName":"南阳路街道"}
         * propertyEntity : {"propertyMoney":"80000.00","propertyPerson":"薛广超","propertyPhone":"18530920798","propertyUnit":"英德物业有限公司"}
         * serverEntity : {"propertyFacilities":"较完善","propertyHealth":"较完善","propertyNice":"较完善","propertySecurity":"较完善"}
         * suitEntity : {"frameCulture":"一般","frameEducation":"一般","frameFinancial":"一般","frameFood":"一般","frameTraffic":"一般"}
         * workEntity : {"BA":"较完善","CA":"较完善","FA":"较完善","OA":"较完善","SA":"较完善"}
         */

        public BasicEntityBean basicEntity;//基本信息
        public PlaceEntityBean placeEntity;//位置信息
        public PropertyEntityBean propertyEntity;//物业信息
        public ServerEntityBean serverEntity;//服务水平
        public SuitEntityBean suitEntity;//配套环境
        public WorkEntityBean workEntity;//办公环境

        public static class BasicEntityBean {
            /**
             * aboveparkingNum : 50
             * allFloor : 20
             * autoliftNum : 50
             * buildArea : 11000
             * buildType : E
             * buildUnit : 恒大地产
             * businessArea : 8000
             * coverArea : 12000
             * floorArea : 200
             * goodliftNum : 50
             * merchantArea : 8000
             * personliftNum : 50
             * underparkingArea : 1000
             * underparkingNum : 50
             * usetime : 2018-01-25
             */

            public int aboveparkingNum;
            public int allFloor;
            public int autoliftNum;
            public int buildArea;
            public String buildType;
            public String buildUnit;
            public int businessArea;
            public int coverArea;
            public int floorArea;
            public int goodliftNum;
            public int merchantArea;
            public int personliftNum;
            public int underparkingArea;
            public int underparkingNum;
            public String usetime;
        }

        public static class PlaceEntityBean {
            /**
             * address : 郑州市南阳路兴隆铺路
             * buildName : 清华园
             * community : 刘寨社区
             * lat : 0
             * lng : 0
             * sliceName : 南阳路街道
             */

            public String address;
            public String buildName;
            public String community;
            public String lat;
            public String lng;
            public String sliceName;
        }

        public static class PropertyEntityBean {
            /**
             * propertyMoney : 80000.00
             * propertyPerson : 薛广超
             * propertyPhone : 18530920798
             * propertyUnit : 英德物业有限公司
             */

            public String propertyMoney;
            public String propertyPerson;
            public String propertyPhone;
            public String propertyUnit;
        }

        public static class ServerEntityBean {
            /**
             * propertyFacilities : 较完善
             * propertyHealth : 较完善
             * propertyNice : 较完善
             * propertySecurity : 较完善
             */

            public String propertyFacilities;
            public String propertyHealth;
            public String propertyNice;
            public String propertySecurity;
        }

        public static class SuitEntityBean {
            /**
             * frameCulture : 一般
             * frameEducation : 一般
             * frameFinancial : 一般
             * frameFood : 一般
             * frameTraffic : 一般
             */

            public String frameCulture;
            public String frameEducation;
            public String frameFinancial;
            public String frameFood;
            public String frameTraffic;
        }

        public static class WorkEntityBean {
            /**
             * BA : 较完善
             * CA : 较完善
             * FA : 较完善
             * OA : 较完善
             * SA : 较完善
             */

            public String BA;
            public String CA;
            public String FA;
            public String OA;
            public String SA;
        }
    }
}
