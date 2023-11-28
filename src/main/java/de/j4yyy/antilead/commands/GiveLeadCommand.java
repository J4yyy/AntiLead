package de.j4yyy.antilead.commands;

import de.j4yyy.antilead.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GiveLeadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Kann nur als Spieler ausgeführt werden!");
            return false;
        }
        Player player = (Player) sender;

        if(!player.hasPermission("antilead.give")) {
            sender.sendMessage(ChatColor.BLUE + "[AntiLead] " + ChatColor.WHITE + " Dir fehlt die Berechtigung: antilead.give");
            return false;
        }

        ItemStack lead = new ItemBuilder(Material.LEAD).setDisplayname(ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "Haustierleine").setLore(ChatColor.WHITE + "Wird zum einfangen benötigt!").build();

        player.getInventory().addItem(lead);
        return false;
    }
}