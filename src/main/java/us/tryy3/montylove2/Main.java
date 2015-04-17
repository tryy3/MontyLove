package us.tryy3.montylove2;

import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.*;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tryy3 on 2015-04-15.
 */
public class Main extends JavaPlugin
{
    //Command Manager
    private CommandsManager<CommandSender> commands;

    @Override
    public void onEnable ()
    {
        setupCommands();
    }

    @Override
    public void onDisable ()
    {
        super.onDisable();
    }

    @Override
    public boolean onCommand (CommandSender sender, Command command, String label, String[] args)
    {
        try
        {
            this.commands.execute(command.getName(), args, sender, sender);
        }
        catch (CommandPermissionsException e)
        {
            sender.sendMessage(ChatColor.RED + "You don't have permission.");
        }
        catch (MissingNestedCommandException e)
        {
            //help command.

            for (Map.Entry<String, String> entry : commands.getCommands().entrySet())
            {
                String key = entry.getKey();
                String value = entry.getValue();

                Bukkit.getLogger().info("KEY: " + key);
                Bukkit.getLogger().info("VALUE: " + value);
            }
        }
        catch (CommandUsageException e)
        {
            sender.sendMessage(ChatColor.RED + e.getMessage());
            sender.sendMessage(ChatColor.RED + e.getUsage());
        }
        catch(WrappedCommandException e)
        {
            if (e.getCause() instanceof  NumberFormatException)
            {
                sender.sendMessage(ChatColor.RED + "Number expected, string recieved instead.");
            }
            else
            {
                sender.sendMessage(ChatColor.RED + "An error has occurred. See console.");
                e.printStackTrace();
            }
        }
        catch (CommandException e)
        {
            sender.sendMessage(ChatColor.RED + e.getMessage());
        }

        return true;
    }

    /**
     *
     * @Desc Initilize all the commands.
     *
     */
    private void setupCommands()
    {
        this.commands = new CommandsManager<CommandSender>()
        {
            @Override
            public boolean hasPermission(CommandSender sender, String perm)
            {
                return sender instanceof ConsoleCommandSender || sender.hasPermission(perm);
            }
        };
        CommandsManagerRegistration cmdRegister = new CommandsManagerRegistration(this, this.commands);
        cmdRegister.register(Commands.ParentCommand.class);
    }

    public void helpCommand()
    {
        for (Map.Entry<String, String> entry : commands.getCommands().entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue();
        }
    }
    public void helpCommand(String help)
    {
    }
}
