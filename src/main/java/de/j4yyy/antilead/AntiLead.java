package de.j4yyy.antilead;

import de.j4yyy.antilead.commands.GiveLeadCommand;
import de.j4yyy.antilead.listener.InteractionListener;
import de.j4yyy.antilead.utils.MountService;
import de.j4yyy.antilead.listener.EntityMountListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class AntiLead extends JavaPlugin {

    @Override
    public void onEnable() {
        MountService mountService = new MountService(this);
        Bukkit.getPluginManager().registerEvents(new InteractionListener(mountService), this);
        Bukkit.getPluginManager().registerEvents(new EntityMountListener(mountService), this);

        Objects.requireNonNull(this.getCommand("petlead")).setExecutor(new GiveLeadCommand());
    }

    @Override
    public void onDisable() {
    }
}