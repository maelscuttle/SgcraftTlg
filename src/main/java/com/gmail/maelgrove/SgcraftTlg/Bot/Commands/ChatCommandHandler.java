package com.gmail.maelgrove.SgcraftTlg.Bot.Commands;

import com.gmail.maelgrove.SgcraftTlg.Core.Telegram.Commands.AbstractCommandHandler;
import com.gmail.maelgrove.SgcraftTlg.Core.Telegram.Commands.Command;
import com.pengrad.telegrambot.model.Message;
import org.bukkit.Bukkit;

/**
 * Represents a Telegram command which sends a chat message to the Minecraft server.
 */
public class ChatCommandHandler extends AbstractCommandHandler {

    private static final String MESSAGE = "%1$s: %2$s";

    @Override
    protected void handleCommand(Command command) {
        if(!command.getName().equals("mcchat"))
            return;

        Message message = command.getUpdate().message();
        String from = message.from().username();

        Bukkit.broadcastMessage(String.format(MESSAGE,
                from, String.join("", command.getParameters())));
    }
}
