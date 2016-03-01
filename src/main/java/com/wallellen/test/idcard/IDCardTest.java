
package com.wallellen.test.idcard;

import com.google.common.io.ByteSource;
import com.google.common.io.Resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * Created by walle on 3/1/16.
 */
public class IDCardTest {

    private static final String httpUrl =
            "http://apis.baidu.com/idl_baidu/ocridcard/ocridcard";
    private static final String httpArg =
            "fromdevice=pc&clientip=10.10.10.0&languagetype=CHN_ENG&image=%s";

    public static void main(String[] args) throws Throwable {
        String img = getImage("./src/main/resources/2.jpg");
//        img = Base64.getEncoder().encodeToString(img.getBytes());
        img = URLEncoder.encode(img);
        System.err.println(img);
        String query = String.format(httpArg, img);
        System.err.println(query);
        System.err.println(query);
        String jsonResult = request(httpUrl, query);
        System.out.println(jsonResult);
    }

    public static String getImage(String str) throws IOException {
//        System.err.println(new File(str).exists());
        URL url = new File(str).toURL();
//        System.err.println(url);

        ByteSource source = Resources.asByteSource(url);
        return Base64.getEncoder().encodeToString(source.read());
    }

    /**
     * @param urlAll  :请求接口
     * @param httpArg :参数
     * @return 返回结果
     */
    public static String request(String httpUrl, String httpArg) {
        System.err.println(httpUrl);
        System.err.println(httpArg);
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey", "ea5d3d9331acf235de5c47f8d6b6f888");
            connection.setDoOutput(true);
            connection.getOutputStream().write(httpArg.getBytes("UTF-8"));
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
