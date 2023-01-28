package me.bludenz.enderbutt.utility;

import me.bludenz.enderbutt.EnderButt;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

// Create and provide EnderButts
public class EnderButtUtils {

    private final EnderButt plugin;

    public EnderButtUtils(EnderButt plugin) {
        this.plugin = plugin;
    }


    public ItemStack createEnderButt(){

        ItemStack EnderButt = new ItemStack(Material.ENDER_PEARL, 1);
        ItemMeta EnderButtMeta = EnderButt.getItemMeta();
        EnderButtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("name")));
        List<String> lore = new ArrayList<>();
        lore.add("Shoot your shot ");
        lore.add("and Teleport anywhere.");
        EnderButtMeta.setLore(lore);
        EnderButt.setItemMeta(EnderButtMeta);

        return EnderButt;


    }

}