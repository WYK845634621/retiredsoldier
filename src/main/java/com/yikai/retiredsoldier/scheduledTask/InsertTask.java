package com.yikai.retiredsoldier.scheduledTask;

import com.yikai.retiredsoldier.entity.Business;
import com.yikai.retiredsoldier.entity.Soldier;
import com.yikai.retiredsoldier.service.BusinessService;
import com.yikai.retiredsoldier.service.SoldierService;
import com.yikai.retiredsoldier.util.RandomValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2019/3/30 8:23
 */
@Component
@EnableScheduling
public class InsertTask {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private SoldierService soldierService;

//    @Scheduled(cron = "0/10 * * * * ?")
    @Scheduled(cron = "0 */15 * * * ?")
    public void insertBusiness(){
        Business business = new Business();
        StringBuffer busName = new StringBuffer();
        for (int i = 0; i <4; i++){
            busName.append(getRandomChinese());
        }
        busName.append("科技公司");
        business.setName(busName.toString());

        business.setAge(RandomValue.getNum(2,20));
        business.setPhone((String) RandomValue.getAddress().get("tel"));
        business.setEmail((String) RandomValue.getAddress().get("email"));
        business.setLocation((String) RandomValue.getAddress().get("road"));
        int flag = (int) (Math.random()*2 + 1);
        if (flag / 2 == 1){
            business.setJob("java开发");
            business.setJobDescribe("五险一金,领导nice");
            business.setRequirement("老实人");
            business.setSalary("8k" + RandomValue.getNum(2,20));
            business.setDataStatus(2);
            business.setKind(flag == 1? "国企":"中外合资");
        }else {
            business.setDataStatus(3);
            business.setKind(flag == 1? "培训机构":"私企");
        }
        business.setContact((String) RandomValue.getAddress().get("name"));
        business.setNationality(RandomValue.getNationality());
        business.setNation(RandomValue.getNation());
        business.setTrade(flag-1);

        business.setTrainProject("java");
        business.setTrainTime(RandomValue.getNum(2,20) + "月");
        business.setTrainArea((String) RandomValue.getAddress().get("road"));
        business.setTrainPhone((String) RandomValue.getAddress().get("tel"));
        business.setCost(flag);
        business.setAdvantage("薪资高待遇好");
        business.setCreateTime(new Date());
        business.setIdCard(String.valueOf(Math.random()+18));

        businessService.insert(business);


        //添加士兵
        Soldier soldier = new Soldier();
        soldier.setName((String)RandomValue.getAddress().get("name"));
        soldier.setAge(RandomValue.getNum(2,20));
        soldier.setGender((int) (Math.random()+1));
        soldier.setWeight(flag==1? "61kg": "57kg");
        soldier.setHeight(flag == 1? "1.84": "1.62");
        soldier.setPhone((String) RandomValue.getAddress().get("tel"));
        soldier.setEmail((String) RandomValue.getAddress().get("email"));
        soldier.setIdentityId(String.valueOf(Math.random()+18));
        soldier.setNationality(RandomValue.getNationality());
        soldier.setNation(RandomValue.getNation());
        soldier.setKind(flag == 1? "空军": flag ==2?"陆军":"海军");
        soldier.setServiceArea(RandomValue.getNationality());
        soldier.setLocation((String) RandomValue.getAddress().get("road"));
        soldier.setIntendJob("java");
        soldier.setDataStatus(1);
        soldier.setCreateTime(new Date());
        soldierService.insert(soldier);
    }

    public static String getRandomChinese() {
        return new String(new char[] { (char) (new Random().nextInt(20902) + 19968) });
    }

}
