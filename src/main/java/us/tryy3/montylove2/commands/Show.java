package us.tryy3.montylove2.commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import org.bukkit.command.CommandSender;

/**
 * Created by tryy3 on 2015-04-15.
 */
public class Show
{
    @Command (aliases = { "show", "s", "info", "i" }, desc = "Show marriage information about someone.", usage = "[player] - The player to show infromation about.", min = 0, max = 1)
    public static void show(final CommandContext args, CommandSender sender) throws CommandException
    {
        throw new CommandException("This command is not finished yet");
    }
}
