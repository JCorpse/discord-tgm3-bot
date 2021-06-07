package idv.sd.bot.discord;


import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;


import discord4j.core.object.entity.Guild;
import discord4j.discordjson.Id;
import discord4j.discordjson.json.ChannelData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Discordbot {
    private final Logger logger = LoggerFactory.getLogger(Discordbot.class);
    private final String TOKEN = "ODUxMTI1MDU5MTUzMTY2MzM2.YLzt-w.WEkznQCFa2cZ0mcu3WP-4Qv_HTQ";
    private final String ChannelId = "812636716640501760";
    private GatewayDiscordClient Client;

    public Discordbot() {
        start();
    }

    public static void main(String[] args) {
        Discordbot a = new Discordbot();
        a.start();
    }

    private void start() {
        try {
            Client = DiscordClientBuilder.create(TOKEN)
                    .build()
                    .login()
                    .block();
//            sendMsg("test");
            //            Client.onDisconnect().block();
        } catch (Exception e) {
            logger.error("Discordbot start error", e);
        }
    }

    public void sendMsg(String content) {
        Client.getRestClient().getChannelById(Snowflake.of(Id.of(ChannelId))).createMessage(content).subscribe();
    }
}
