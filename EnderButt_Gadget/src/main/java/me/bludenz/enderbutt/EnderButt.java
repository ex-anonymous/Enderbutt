package me.bludenz.enderbutt;

import me.bludenz.enderbutt.commands.GiveCommand;
import me.bludenz.enderbutt.listeners.EnderButtListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnderButt extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new EnderButtListener(this), this);

        getCommand("enderbutt").setExecutor(new GiveCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
