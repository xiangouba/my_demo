package com.example.demo;

import com.example.demo.service.serviceImpl.TestImpl;
import org.junit.Test;
import org.maxkey.client.http.Response;
import org.maxkey.client.oauth.builder.api.MaxkeyPasswordApi20;
import org.maxkey.client.oauth.model.OAuthConfig;
import org.maxkey.client.oauth.model.Token;
import org.maxkey.client.oauth.oauth.OAuthPasswordService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author gxx
 * @Date 2023年06月28日09时05分
 */
@SpringBootTest
public class TestDemo {
    @Test
    public void test1() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String salesman = "李腾峰";
        String business_license_no = "00012121038100102021000563";
        Date license_valid_start_date = dateFormat.parse("2021-09-27");
        Date license_expiration_date = dateFormat.parse("9999-01-01");
        String salesman_id = "100137101";
        String policy_num = "880052608993";
        Date policy_signing_date = dateFormat.parse("2022-10-19");
        String policy_number2 = "108686310000080036";
        String comptxt = "辽宁分公司鞍山中心支公司海城营销服务部";
        String compid = "86310303";
        String g_version = "核心业务系统";



        String str =  "RsSalesmanInfo{" +
                "salesman='" + salesman + '\'' +
                ", business_license_no='" + business_license_no + '\'' +
                ", license_valid_start_date=" + license_valid_start_date +
                ", license_expiration_date=" + license_expiration_date +
                ", salesman_id='" + salesman_id + '\'' +
                ", policy_num='" + policy_num + '\'' +
                ", policy_signing_date=" + policy_signing_date +
                ", policy_number2='" + policy_number2 + '\'' +
                ", comptxt='" + comptxt + '\'' +
                ", compid='" + compid + '\'' +
                ", g_version='" + g_version + '\'' +
                '}';

        String md5 =encrypt(str);
        System.out.printf("第一个加密：" + md5);

        String md5S = md5(str);

        System.out.println("第二个加密：" + md5S);

        String md5ss = DigestUtils.md5DigestAsHex(str.getBytes());

        System.out.println("第三个加密：" + md5ss);

    }

    public static String encrypt(String dataStr) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(dataStr.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        return md5Str;
    }

    public static String md5(String dateString) throws Exception {
        MessageDigest md5 = null;
        byte[] digest = MessageDigest.getInstance("md5").digest(dateString.getBytes("utf-8"));
        String md5code = new BigInteger(1, digest).toString(16);
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    @Test
    public void test2(){
        byte a = 5;

        double b = 0.03;
        double b2 = 300.03;

        System.out.println(a + b + b2);
    }

    @Test
    public void test3(){
        String a = "abcde";
        a.substring(0);
    }

    @Test
    public void test4(){

        char a[] = {'a','b','c','d'};
        String b = new String(a,2,0);
        System.out.println(b);
    }

    @Test
    public void test5(){

        TestImpl test = new TestImpl();
        test.test();
        test.test1();
    }

    @Test
    public void test6() throws Exception {
        Class<?> clazz = Class.forName("com.example.demo.service.serviceImpl.TestImpl");
        // 调用实现了的方法
        Method method = clazz.getMethod("test1");
        method.invoke(clazz.newInstance());

        System.out.println("-----------------------分割线-------------------");

        //调用接口默认实现了的方法
        method = clazz.getMethod("test");
        method.invoke(clazz.newInstance());

    }

    @Test
    public void test7(){
            String accessTokenUrl="http://sso.maxkey.top/sign/authz/oauth/v20/token";
            String clientId = "b32834accb544ea7a9a09dcae4a36403";
            String clientSerect = "E9UO53P3JH52aQAcnLP2FlLv8olKIB7u";

            String callback = "http://oauth.demo.maxkey.top:8080/demo-oauth/oauth20callback.jsp";
            String responseType ="token";
            String approvalprompt = "auto";

            OAuthConfig oauthServiceConfig=new OAuthConfig(clientId,clientSerect,callback);
            MaxkeyPasswordApi20 passwordApi20=new MaxkeyPasswordApi20(accessTokenUrl);
            OAuthPasswordService oAuthPasswordService=new OAuthPasswordService(oauthServiceConfig,passwordApi20);
            Token accessToken = null;
            Response response = null;
            accessToken = oAuthPasswordService.getAccessToken("admin", "maxkey");
    }
}
