import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.message.MessageCreateEvent;

public class Main {
    public static void main(String[] args) {
        DiscordClient client = new DiscordClientBuilder("MzI5NDU0NDczNTk0NDA0ODY2.Dxb_Cw.Zfju6XB3uZvRFsftndQY_ko02oo").build();
        client.getEventDispatcher().on(MessageCreateEvent.class)
                .doOnNext(event -> event.getMessage().getContent().ifPresent(c -> System.out.println(c)))
                .subscribe();
        client.login().block();
    }
}
