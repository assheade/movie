package com.chuanmei.movie.util;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class QiniuTool {
    /**
     * 上传到七牛云服务器上的图片的绝对路径
     * @param localFilePath
     */
    public static String upload(String localFilePath) {
        String returnPath = null;
        // 构造一个带指定 Region 对象的配置类
        @SuppressWarnings("deprecation")
        Configuration cfg = new Configuration(Zone.zone2()); // 需要改你的存储空间的位置
        // ...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        // ...生成上传凭证，然后准备上传
        String accessKey = "vtPis4Kl0ewwpDcX5ROAqfaX3QAg9jDg84etTfZp"; // 写你自己的key
        String secretKey = "9DH62QUEbRdeeOB3LR8iDu3qibLiyHkksOyuZkg-";// 写你自己的密码
        String bucket = "movie11"; // 你的项目的空间名称
        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            returnPath = "http://qva9sdovf.hn-bkt.clouddn.com/" + putRet.key;

        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                // ignore
            }
        }
        return returnPath;
    }


    //http://qva9sdovf.hn-bkt.clouddn.com/FtmX4cN-3AWth9A2A-Mq1JXuLPzh
    public static void main(String[] args) {
        upload("D:\\files\\Hydrangeas.jpg");
    }

}
