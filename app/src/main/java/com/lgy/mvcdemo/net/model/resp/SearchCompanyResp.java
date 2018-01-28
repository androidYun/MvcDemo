package com.lgy.mvcdemo.net.model.resp;

import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 */

public class SearchCompanyResp {

    /**
     * command : 5
     * result : 0
     * errorMsg :
     * CompanyList : [{"basicEntity":{"companyCredit":"","companyLicense":"410104000015907","companyName":"郑州智领科技有限公司","companyTax":"","companyType":"C","contactPerson":"胡斌","contactPhone":"18530920798","economicType":"民营企业","headPerson":"胡斌","industry":"M","legalPerson":"胡斌","legalPhone":"18530920798","listedType":"A","regAddress":"郑州市经三路农科路绿洲银郡","regMoney":"30000000.00"},"otherEntity":{"employNum":"否","emptyAccount":null,"inTime":"2018/1/25 6:11:56","monthRent":"8000.00","productType":"第三产业","roomMaster":"郑州智领科技有限公司","taxAgency":"A"},"placeEntity":{"buildName":"清华园","buildNo":"13","businessNo":"","community":"刘寨社区","companyArea":"500","floorNo":"25","roomNo":"2501","seatNo":"","sliceName":"南阳路街道"}}]
     */

    private int command;
    private int result;
    private String errorMsg;
    private List<CompanyListBean> CompanyList;

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<CompanyListBean> getCompanyList() {
        return CompanyList;
    }

    public void setCompanyList(List<CompanyListBean> CompanyList) {
        this.CompanyList = CompanyList;
    }

    public static class CompanyListBean {
        /**
         * basicEntity : {"companyCredit":"","companyLicense":"410104000015907","companyName":"郑州智领科技有限公司","companyTax":"","companyType":"C","contactPerson":"胡斌","contactPhone":"18530920798","economicType":"民营企业","headPerson":"胡斌","industry":"M","legalPerson":"胡斌","legalPhone":"18530920798","listedType":"A","regAddress":"郑州市经三路农科路绿洲银郡","regMoney":"30000000.00"}
         * otherEntity : {"employNum":"否","emptyAccount":null,"inTime":"2018/1/25 6:11:56","monthRent":"8000.00","productType":"第三产业","roomMaster":"郑州智领科技有限公司","taxAgency":"A"}
         * placeEntity : {"buildName":"清华园","buildNo":"13","businessNo":"","community":"刘寨社区","companyArea":"500","floorNo":"25","roomNo":"2501","seatNo":"","sliceName":"南阳路街道"}
         */

        private BasicEntityBean basicEntity;
        private OtherEntityBean otherEntity;
        private PlaceEntityBean placeEntity;

        public BasicEntityBean getBasicEntity() {
            return basicEntity;
        }

        public void setBasicEntity(BasicEntityBean basicEntity) {
            this.basicEntity = basicEntity;
        }

        public OtherEntityBean getOtherEntity() {
            return otherEntity;
        }

        public void setOtherEntity(OtherEntityBean otherEntity) {
            this.otherEntity = otherEntity;
        }

        public PlaceEntityBean getPlaceEntity() {
            return placeEntity;
        }

        public void setPlaceEntity(PlaceEntityBean placeEntity) {
            this.placeEntity = placeEntity;
        }

        public static class BasicEntityBean {
            /**
             * companyCredit :
             * companyLicense : 410104000015907
             * companyName : 郑州智领科技有限公司
             * companyTax :
             * companyType : C
             * contactPerson : 胡斌
             * contactPhone : 18530920798
             * economicType : 民营企业
             * headPerson : 胡斌
             * industry : M
             * legalPerson : 胡斌
             * legalPhone : 18530920798
             * listedType : A
             * regAddress : 郑州市经三路农科路绿洲银郡
             * regMoney : 30000000.00
             */

            private String companyCredit;
            private String companyLicense;
            private String companyName;
            private String companyTax;
            private String companyType;
            private String contactPerson;
            private String contactPhone;
            private String economicType;
            private String headPerson;
            private String industry;
            private String legalPerson;
            private String legalPhone;
            private String listedType;
            private String regAddress;
            private String regMoney;

            public String getCompanyCredit() {
                return companyCredit;
            }

            public void setCompanyCredit(String companyCredit) {
                this.companyCredit = companyCredit;
            }

            public String getCompanyLicense() {
                return companyLicense;
            }

            public void setCompanyLicense(String companyLicense) {
                this.companyLicense = companyLicense;
            }

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getCompanyTax() {
                return companyTax;
            }

            public void setCompanyTax(String companyTax) {
                this.companyTax = companyTax;
            }

            public String getCompanyType() {
                return companyType;
            }

            public void setCompanyType(String companyType) {
                this.companyType = companyType;
            }

            public String getContactPerson() {
                return contactPerson;
            }

            public void setContactPerson(String contactPerson) {
                this.contactPerson = contactPerson;
            }

            public String getContactPhone() {
                return contactPhone;
            }

            public void setContactPhone(String contactPhone) {
                this.contactPhone = contactPhone;
            }

            public String getEconomicType() {
                return economicType;
            }

            public void setEconomicType(String economicType) {
                this.economicType = economicType;
            }

            public String getHeadPerson() {
                return headPerson;
            }

            public void setHeadPerson(String headPerson) {
                this.headPerson = headPerson;
            }

            public String getIndustry() {
                return industry;
            }

            public void setIndustry(String industry) {
                this.industry = industry;
            }

            public String getLegalPerson() {
                return legalPerson;
            }

            public void setLegalPerson(String legalPerson) {
                this.legalPerson = legalPerson;
            }

            public String getLegalPhone() {
                return legalPhone;
            }

            public void setLegalPhone(String legalPhone) {
                this.legalPhone = legalPhone;
            }

            public String getListedType() {
                return listedType;
            }

            public void setListedType(String listedType) {
                this.listedType = listedType;
            }

            public String getRegAddress() {
                return regAddress;
            }

            public void setRegAddress(String regAddress) {
                this.regAddress = regAddress;
            }

            public String getRegMoney() {
                return regMoney;
            }

            public void setRegMoney(String regMoney) {
                this.regMoney = regMoney;
            }
        }

        public static class OtherEntityBean {
            /**
             * employNum : 否
             * emptyAccount : null
             * inTime : 2018/1/25 6:11:56
             * monthRent : 8000.00
             * productType : 第三产业
             * roomMaster : 郑州智领科技有限公司
             * taxAgency : A
             */

            private String employNum;
            private Object emptyAccount;
            private String inTime;
            private String monthRent;
            private String productType;
            private String roomMaster;
            private String taxAgency;

            public String getEmployNum() {
                return employNum;
            }

            public void setEmployNum(String employNum) {
                this.employNum = employNum;
            }

            public Object getEmptyAccount() {
                return emptyAccount;
            }

            public void setEmptyAccount(Object emptyAccount) {
                this.emptyAccount = emptyAccount;
            }

            public String getInTime() {
                return inTime;
            }

            public void setInTime(String inTime) {
                this.inTime = inTime;
            }

            public String getMonthRent() {
                return monthRent;
            }

            public void setMonthRent(String monthRent) {
                this.monthRent = monthRent;
            }

            public String getProductType() {
                return productType;
            }

            public void setProductType(String productType) {
                this.productType = productType;
            }

            public String getRoomMaster() {
                return roomMaster;
            }

            public void setRoomMaster(String roomMaster) {
                this.roomMaster = roomMaster;
            }

            public String getTaxAgency() {
                return taxAgency;
            }

            public void setTaxAgency(String taxAgency) {
                this.taxAgency = taxAgency;
            }
        }

        public static class PlaceEntityBean {
            /**
             * buildName : 清华园
             * buildNo : 13
             * businessNo :
             * community : 刘寨社区
             * companyArea : 500
             * floorNo : 25
             * roomNo : 2501
             * seatNo :
             * sliceName : 南阳路街道
             */

            private String buildName;
            private String buildNo;
            private String businessNo;
            private String community;
            private String companyArea;
            private String floorNo;
            private String roomNo;
            private String seatNo;
            private String sliceName;

            public String getBuildName() {
                return buildName;
            }

            public void setBuildName(String buildName) {
                this.buildName = buildName;
            }

            public String getBuildNo() {
                return buildNo;
            }

            public void setBuildNo(String buildNo) {
                this.buildNo = buildNo;
            }

            public String getBusinessNo() {
                return businessNo;
            }

            public void setBusinessNo(String businessNo) {
                this.businessNo = businessNo;
            }

            public String getCommunity() {
                return community;
            }

            public void setCommunity(String community) {
                this.community = community;
            }

            public String getCompanyArea() {
                return companyArea;
            }

            public void setCompanyArea(String companyArea) {
                this.companyArea = companyArea;
            }

            public String getFloorNo() {
                return floorNo;
            }

            public void setFloorNo(String floorNo) {
                this.floorNo = floorNo;
            }

            public String getRoomNo() {
                return roomNo;
            }

            public void setRoomNo(String roomNo) {
                this.roomNo = roomNo;
            }

            public String getSeatNo() {
                return seatNo;
            }

            public void setSeatNo(String seatNo) {
                this.seatNo = seatNo;
            }

            public String getSliceName() {
                return sliceName;
            }

            public void setSliceName(String sliceName) {
                this.sliceName = sliceName;
            }
        }
    }
}
