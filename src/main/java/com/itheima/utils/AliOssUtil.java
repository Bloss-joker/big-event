package com.itheima.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;

import java.io.FileInputStream;
import java.io.InputStream;

public class AliOssUtil {

    // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
    private static final String ENDPOINT = "https://oss-cn-beijing.aliyuncs.com";
    // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
    //EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
    private static final String OSS_ACCESS_KEY_ID = "LTAI5tJHQP3w3WMyRDX99Wx3";
    private static final String OSS_ACCESS_KEY_SECRET = "w5CQIs1wGzL0y6KlcvhCsvAEfl1Ikm";
    // 填写Bucket名称，例如examplebucket。
    private static final String BUCKETNAME = "big-event-root";

    public static String uploadFiles(String objectName, InputStream in) throws Exception {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, OSS_ACCESS_KEY_ID,OSS_ACCESS_KEY_SECRET);
        String url="";

        try {
            String content = "Hello OSS";
            ossClient.putObject(BUCKETNAME, objectName, in);
            url = "https://" + BUCKETNAME + "." +ENDPOINT.substring(ENDPOINT.lastIndexOf("/")+1) + "/" + objectName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }

}
