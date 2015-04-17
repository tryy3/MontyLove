package us.tryy3.montylove2.commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import org.bukkit.command.CommandSender;

/**
 * Created by tryy3 on 2015-04-15.
 */
public class Propose
{
    @Command (aliases = { "propose", "p", "prop" }, desc = "Propose to someone..", usage = "(player) - The player to propose to.", min = 1, max = 1)
    public static void propose(final CommandContext args, CommandSender sender) throws CommandException
    {
        throw new CommandException("This command is not finished yet");
    }
}
