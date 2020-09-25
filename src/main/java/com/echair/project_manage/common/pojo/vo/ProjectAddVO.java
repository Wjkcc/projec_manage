package com.echair.project_manage.common.pojo.vo;

import com.echair.project_manage.common.pojo.base.TimestampBase;
import com.echair.project_manage.dao.model.Alpha;
import lombok.Data;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/24 14:59
 **/
@Data
public class ProjectAddVO extends TimestampBase {
//    "projectName":"sss", // 项目名称
//            "begin":"2020-22-22", //
//            "end":"2020-22-22-", //
//            "rank":2 ,// 1 2 3 星级
//            "constractName":"22", // 联系人
//            "constractTel":"1212", // 联系人方式
//            "versionName":"22",// 版本名称
//            "versionId":22,// 版本id
//            "manageName":"xxx", // 负责人
//            "manageUserid":"xxx", //
//            "data":"tttt", // 资料
//            "alpha":{
//        "frontUe":"xx", //前端ue
//                "frontUi":"xxx", //前端ui
//                "backUe":"xxx", //后端ue
//                "backUi":"xxx", //后端ui
//                "svn":"xxx", //
//                "requirementDoc":"xxx", // 需求文档
//                "acceptanceDoc":"xxx", // 验收文档
        private String projectName;
        private String contractName;
        private String contractTel;
        private Integer rank;
        private String versionName;
        private Integer versionId;
        private String managerName;
        private String managerUserid;
        private String data;
        private Alpha alpha;

}
