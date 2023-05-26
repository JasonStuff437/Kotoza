package org.bukkit.command.defaults;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import java.util.Collections;

public class ReloadCommand extends BukkitCommand {
    public ReloadCommand(final String name) {
        super(name);
        this.description = "Reloads the server configuration and plugins";
        this.usageMessage = "/reload";
        this.setPermission("bukkit.command.reload");
        this.setAliases(Collections.singletonList("rl"));
    }

    @Override
    public boolean execute(final CommandSender sender, final String currentAlias, final String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }
        /*
         * Reload has a tendency to be unsafe and may cause server instabilities,
         * as it disables/re-enables plugin(s) in a way that may not be safe/efficient.
         * The best solution is to reload every plugin's config instead.
         * => USE AT YOUR OWN RISK <=
         * Reload feature re-enabled. ~Jason437 07/01/2022.
         */
        Bukkit.reload();
        sender.sendMessage(ChatColor.GREEN + "Reload complete.");
        // sender.sendMessage(ChatColor.GREEN + "Reload not allowed on a forge bukkit server.");
        return true;
    }
}
