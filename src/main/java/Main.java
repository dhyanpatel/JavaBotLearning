import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.PrivateChannel;
import discord4j.core.object.util.Snowflake;
import discord4j.voice.json.Ready;

public class Main {
    public static void main(String[] args) {


        final DiscordClient client = new DiscordClientBuilder("MzI5NDU0NDczNTk0NDA0ODY2.Dxb_Cw.Zfju6XB3uZvRFsftndQY_ko02oo").build();

        client.getEventDispatcher().on(ReadyEvent.class)
                .map(ReadyEvent::getClient)
                .flatMap(client1 -> client1.getUserById(Snowflake.of(135027504367796224L)))
                .flatMap(user -> user.getPrivateChannel())
                .flatMap(channel -> channel.createMessage("Bot is up and ready!"))
                .subscribe();

        client.getEventDispatcher().on(MessageCreateEvent.class)
                .map(MessageCreateEvent::getMessage)
                .flatMap(message -> message.getChannel())
                .flatMap(messageChannel -> messageChannel.createMessage("The User's Original Message"))
                .subscribe();

        // Starts up Bot
        client.login().block();
    }
}
