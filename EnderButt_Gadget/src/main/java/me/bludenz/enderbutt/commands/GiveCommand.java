package me.bludenz.enderbutt.commands;

import me.bludenz.enderbutt.EnderButt;
import me.bludenz.enderbutt.utility.EnderButtUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveCommand implements CommandExecutor {

    private final EnderButt plugin;
    private final EnderButtUtils EnderButtUtils;

    public GiveCommand(EnderButt plugin) {
        this.plugin = plugin;
        this.EnderButtUtils = new EnderButtUtils(plugin);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("enderbutt.give")) {

                if (args.length == 0) {

                    ItemStack EnderButt = EnderButtUtils.createEnderButt();
                    p.getInventory().addItem(EnderButt);

                    p.sendMessage(ChatColor.GREEN + "You have given yourself an EnderButt!");

                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target == null) {
                        p.sendMessage(ChatColor.RED + "This player doesn't exist");

                        return true;
                    }

                    ItemStack EnderButt = EnderButtUtils.createEnderButt();
                    target.getInventory().addItem(EnderButt);

                    target.sendMessage(ChatColor.GREEN + "You have been given an EnderButt!");

                }

            }else{
                p.sendMessage(ChatColor.RED + "You do not have permission!");
            }

        }

        return true;
    }

}
