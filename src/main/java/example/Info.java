package example;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.message.data.MessageChain;

public class Info extends SimpleListenerHost {
    @EventHandler
    public void onMessage(MessageEvent event) {
        MessageChain chain = event.getMessage(); // 可获取到消息内容等, 详细查阅 `GroupMessageEvent`
        String msg = chain.contentToString();
        event.getSubject().sendMessage(msg);
    }
}
