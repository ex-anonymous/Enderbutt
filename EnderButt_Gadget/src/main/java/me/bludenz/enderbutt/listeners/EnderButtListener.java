package me.bludenz.enderbutt.listeners;

import me.bludenz.enderbutt.EnderButt;
import me.bludenz.enderbutt.utility.EnderButtUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;


public class EnderButtListener implements Listener {

    private final EnderButt plugin;
    private final EnderButtUtils EnderButtUtils;

    public EnderButtListener(EnderButt plugin) {
        this.plugin = plugin;
        this.EnderButtUtils = new EnderButtUtils(plugin);
    }


    @EventHandler
    public void onPearlLand(ProjectileHitEvent e) {

        //Check to see if it was shot by a Teleport Bow
        if (e.getEntity().getShooter() instanceof Player) {
            Player p = (Player) e.getEntity().getShooter();

            ItemStack itemInMainHand = p.getInventory().getItemInHand();
            if (itemInMainHand.getItemMeta().getDisplayName().equalsIgnoreCase(plugin.getConfig().getString("name"))) {

                Location location = e.getEntity().getLocation();

                p.teleport(location);
                e.getEntity().remove();

            }

        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        if (plugin.getConfig().getBoolean("give-on-join")) {

            Player p = e.getPlayer();

            p.getInventory().addItem(EnderButtUtils.createEnderButt());
        }

    }


}
