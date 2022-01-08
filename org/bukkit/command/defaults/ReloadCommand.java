package org.bukkit.command.defaults;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import java.util.Arrays;

public class ReloadCommand extends BukkitCommand
{
    public ReloadCommand(final String name)
    {
        super(name);
        this.description = "Reloads the server configuration and plugins";
        this.usageMessage = "/reload";
        this.setPermission("bukkit.command.reload");
        this.setAliases(Arrays.asList("rl"));
    }
    
    @Override
    public boolean execute(final CommandSender sender, final String currentAlias, final String[] args)
    {
        if (!this.testPermission(sender)) 
        {
            return true;
        }
        /** 
         * Reload has tendency to be unsafe, and may cause server instabilities,
         * due to it disable/re-enabling plugins which theres no safe/efficient 
         * way of doing so, best solution it to reload every plugin(s) config instead. 
         * => USE AT YOUR OWN RISK <=
         * Reload feature re-enabled. ~Jason437 07/01/2022.
         */        
        Bukkit.reload();
        sender.sendMessage(ChatColor.GREEN + "Reload complete.");
        //sender.sendMessage(ChatColor.GREEN + "Reload not allowed on a forge bukkit server.");
        return true;
    }
}
