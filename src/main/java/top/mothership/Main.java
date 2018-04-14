package top.mothership;

import com.google.gson.GsonBuilder;
import okhttp3.*;

import java.io.*;
import java.time.Instant;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        //这一串是获取当前目录的
        java.net.URL url = Main.class.getProtectionDomain().getCodeSource().getLocation();
        String jarFilePath = null;
        try {
            jarFilePath = java.net.URLDecoder.decode(url.getPath(), "utf-8");
        } catch (Exception e) {
            System.err.println(Instant.now() + " 解析JAR运行路径失败。程序即将退出，请手动关闭并提交Issue");
            TimeUnit.DAYS.sleep(100);
            return;
        }
        if (jarFilePath.endsWith(".exe"))
            jarFilePath = jarFilePath.substring(0, jarFilePath.lastIndexOf("/") + 1);
        java.io.File file = new java.io.File(jarFilePath);
        jarFilePath = file.getAbsolutePath();
        //读取配置
        File configFile = new File(jarFilePath + "\\config.ini");
        if (configFile.exists()) {
            //如果配置存在，读取路径覆盖掉默认文件路径
            try(InputStream in =
                        new FileInputStream(configFile)){
                properties.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(properties.getProperty("RoomID")!=null&&properties.getProperty("Cookies")!=null) {
                System.out.println(Instant.now() + " 读取配置文件成功，房间号是：" + properties.getProperty("RoomID"));
            }else{
                System.out.println(Instant.now() + "错误：解析config.ini失败，程序即将退出。" +
                        "\n请确认本程序与Sync.exe处于同一目录下，并且Default Plug-ins.BiliBili插件已启动！");
                TimeUnit.SECONDS.sleep(10);
                return;
            }
        } else {
            System.out.println(Instant.now() + "错误：没有找到config.ini。" +
                    "\n请确认本程序与Sync.exe处于同一目录下，并且Default Plug-ins.BiliBili插件已启动！");
                TimeUnit.SECONDS.sleep(10);
                return;
        }
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType,
                "room_id="+properties.getProperty("RoomID")
                +"&platform=pc&area_v2=107");
        Request request = new Request.Builder()
                .url("http://api.live.bilibili.com/room/v1/Room/startLive")
                .post(body)
                .addHeader("cookie", properties.getProperty("Cookies"))
                .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            System.out.println(Instant.now() + "执行完毕，结果是：");
            System.out.print( Instant.now() +new GsonBuilder().create().fromJson(response.body().string(),BiliBiliResponse.class).toString());
//            System.out.print(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        TimeUnit.SECONDS.sleep(3);
    }
}
