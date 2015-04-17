package us.tryy3.montylove2;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.NestedCommand;
import org.bukkit.command.CommandSender;
import us.tryy3.montylove2.commands.*;

/**
 * Created by tryy3 on 2015-04-15.
 */
public class Commands {
    public static class ParentCommand {
        @Command (aliases = { "montylove", "ml", "love", "marry", "m", "marriage", "date", "d" }, desc = "MontyLove Commands", min = 0, max = -1)
        @NestedCommand ({ Accept.class, Deny.class, Divorce.class, Propose.class, Show.class})
        public static void montylove(final CommandContext args, CommandSender sender) throws CommandException
        {
        }
    }
}