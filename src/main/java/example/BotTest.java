package example;

import com.github.dr.rwserver.data.global.Data;
import com.github.dr.rwserver.util.file.FileUtil;
import com.github.dr.rwserver.util.log.Log;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.utils.BotConfiguration;

import java.security.MessageDigest;

public class BotTest {
    public Bot bot;
    public BotTest() {
        long account = 123456;
        String password = "passwd";
        bot = BotFactory.INSTANCE.newBot(account, md5Bytes(password), new BotConfiguration() {
            {
                // 我建议使用可以正常登陆的设备配置文件 或者登陆成功后拷贝一份
                fileBasedDeviceInfo(FileUtil.file(Data.Plugin_Data_Path).toPath("deviceInfo.json").getPath());
            }
        });
        Log.info("尝试登入...");
        bot.login();
        Log.info("初始化事件系统...");
        GlobalEventChannel.INSTANCE.registerListenerHost(new Info());
        Log.info("初始化指令系统...");
        bot.join();
    }

    public static byte[] md5Bytes(String input) {
        try {
            byte[] resultByteArray = MessageDigest.getInstance("MD5").digest(input.getBytes("UTF-8"));
            return resultByteArray;
        } catch (Exception e) {
            Log.error(e);
        }
        return null;
    }
}
