package com.johntaylor.jtpunish.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.johntaylor.jtpunish.jtPunish;

import net.md_5.bungee.api.ChatColor;

public class PunishCommand implements CommandExecutor, Listener {	
	
	@SuppressWarnings({ "deprecation" })
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
			return true;
		}
		if(!sender.hasPermission("jtpunish.punish") && !sender.isOp()) {
			sender.sendMessage(ChatColor.RED + "No permission");
			return true;
		}
		if(args.length != 1) {
			sender.sendMessage(ChatColor.RED + "/punish [player]");
			return true;
		}
		Player target = Bukkit.getPlayer(args[0]);
		if(target == sender) {
			sender.sendMessage(ChatColor.RED + "You can't punish yourself.");
			return true;
		}
		Inventory punishInv = Bukkit.createInventory(null, 72, ChatColor.BLACK + "[" + ChatColor.RED + "jtPunish" + ChatColor.BLACK + "]");
		//Target Head
		ItemStack targetHead = new ItemStack(Material.SKULL_ITEM, 1, (byte)3);
		SkullMeta targetMeta = (SkullMeta) targetHead.getItemMeta();
		targetMeta.setOwner(args[0]);
		targetMeta.setDisplayName(args[0]);
		targetHead.setItemMeta(targetMeta);
		punishInv.setItem(66, targetHead);
		//Exit
		ItemStack exitItem = new ItemStack(Material.COMPASS);
		ItemMeta exitMeta = exitItem.getItemMeta();
		exitMeta.setDisplayName(ChatColor.RED + "Exit");
		exitItem.setItemMeta(exitMeta);
		punishInv.setItem(68, exitItem);
		//FirstOffence
		ItemStack firstItem = new ItemStack(351, 1, (short) 10);
		ItemMeta firstMeta = firstItem.getItemMeta();
		firstMeta.setDisplayName(ChatColor.GREEN + "First Offence");
		firstItem.setItemMeta(firstMeta);
		punishInv.setItem(67, firstItem);
		//TempMute
		ItemStack muteItem = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getData());
		ItemMeta muteMeta = muteItem.getItemMeta();
		muteMeta.setDisplayName(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute.Name"));
		muteMeta.setLore(Arrays.asList(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute.Lore1"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute.Lore2"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute.Lore3"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute.Lore4")));
		muteMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
		muteItem.setItemMeta(muteMeta);
		punishInv.setItem(0, muteItem);
		//PermMute
		ItemStack permmuteItem = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
		ItemMeta permmuteMeta = permmuteItem.getItemMeta();
		permmuteMeta.setDisplayName(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute.Name"));
		permmuteMeta.setLore(Arrays.asList(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute.Lore1"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute.Lore2"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute.Lore3"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute.Lore4")));
		permmuteMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
		permmuteItem.setItemMeta(permmuteMeta);
		punishInv.setItem(18, permmuteItem);
		//TempBan
		ItemStack tempbanItem = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getData());
		ItemMeta tempbanMeta = tempbanItem.getItemMeta();
		tempbanMeta.setDisplayName(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan.Name"));
		tempbanMeta.setLore(Arrays.asList(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan.Lore1"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan.Lore2"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan.Lore3"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan.Lore4")));
		tempbanMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
		tempbanItem.setItemMeta(tempbanMeta);
		punishInv.setItem(36, tempbanItem);
		//PermBan
		ItemStack permbanItem = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
		ItemMeta permbanMeta = permbanItem.getItemMeta();
		permbanMeta.setDisplayName(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan.Name"));
		permbanMeta.setLore(Arrays.asList(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan.Lore1"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan.Lore2"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan.Lore3"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan.Lore4")));
		permbanMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
		permbanItem.setItemMeta(permbanMeta);
		punishInv.setItem(54, permbanItem);
		//TempMute1
		ItemStack tempmuteItem1 = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getData());
		ItemMeta tempmuteMeta1 = tempmuteItem1.getItemMeta();
		tempmuteMeta1.setDisplayName(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute1.Name"));
		tempmuteMeta1.setLore(Arrays.asList(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute1.Lore1"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute1.Lore2"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute1.Lore3"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute1.Lore4")));
		tempmuteItem1.setItemMeta(tempmuteMeta1);
		punishInv.setItem(2, tempmuteItem1);
		//TempMute2
		ItemStack tempmuteItem2 = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getData());
		ItemMeta tempmuteMeta2 = tempmuteItem2.getItemMeta();
		tempmuteMeta2.setDisplayName(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute2.Name"));
		tempmuteMeta2.setLore(Arrays.asList(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute2.Lore1"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute2.Lore2"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute2.Lore3"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute2.Lore4")));
		tempmuteItem2.setItemMeta(tempmuteMeta2);
		punishInv.setItem(3, tempmuteItem2);
		//TempMute3
		ItemStack tempmuteItem3 = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getData());
		ItemMeta tempmuteMeta3 = tempmuteItem3.getItemMeta();
		tempmuteMeta3.setDisplayName(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute3.Name"));
		tempmuteMeta3.setLore(Arrays.asList(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute3.Lore1"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute3.Lore2"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute3.Lore3"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute3.Lore4")));
		tempmuteItem3.setItemMeta(tempmuteMeta3);
		punishInv.setItem(4, tempmuteItem3);
		//TempMute4
		ItemStack tempmuteItem4 = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getData());
		ItemMeta tempmuteMeta4 = tempmuteItem4.getItemMeta();
		tempmuteMeta4.setDisplayName(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute4.Name"));
		tempmuteMeta4.setLore(Arrays.asList(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute4.Lore1"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute4.Lore2"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute4.Lore3"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute4.Lore4")));
		tempmuteItem4.setItemMeta(tempmuteMeta4);
		punishInv.setItem(5, tempmuteItem4);
		//TempMute5
		ItemStack tempmuteItem5 = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getData());
		ItemMeta tempmuteMeta5 = tempmuteItem5.getItemMeta();
		tempmuteMeta5.setDisplayName(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute5.Name"));
		tempmuteMeta5.setLore(Arrays.asList(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute5.Lore1"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute5.Lore2"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute5.Lore3"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute5.Lore4")));
		tempmuteItem5.setItemMeta(tempmuteMeta5);
		punishInv.setItem(6, tempmuteItem5);
		//TempMute6
		ItemStack tempmuteItem6 = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getData());
		ItemMeta tempmuteMeta6 = tempmuteItem6.getItemMeta();
		tempmuteMeta6.setDisplayName(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute6.Name"));
		tempmuteMeta6.setLore(Arrays.asList(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute6.Lore1"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute6.Lore2"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute6.Lore3"), ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute6.Lore4")));
		tempmuteItem6.setItemMeta(tempmuteMeta6);
		punishInv.setItem(7, tempmuteItem6);
		//PermMute1
		ItemStack permmuteItem1 = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
		ItemMeta permmuteMeta1 = permmuteItem1.getItemMeta();
		permmuteMeta1.setDisplayName(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute1.Name"));
		permmuteMeta1.setLore(Arrays.asList(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute1.Lore1"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute1.Lore2"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute1.Lore3"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute1.Lore4")));
		permmuteItem1.setItemMeta(permmuteMeta1);
		punishInv.setItem(20, permmuteItem1);
		//PermMute2
		ItemStack permmuteItem2 = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
		ItemMeta permmuteMeta2 = permmuteItem2.getItemMeta();
		permmuteMeta2.setDisplayName(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute2.Name"));
		permmuteMeta2.setLore(Arrays.asList(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute2.Lore1"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute2.Lore2"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute2.Lore3"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute2.Lore4")));
		permmuteItem2.setItemMeta(permmuteMeta2);
		punishInv.setItem(21, permmuteItem2);
		//PermMute3
		ItemStack permmuteItem3 = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
		ItemMeta permmuteMeta3 = permmuteItem3.getItemMeta();
		permmuteMeta3.setDisplayName(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute3.Name"));
		permmuteMeta3.setLore(Arrays.asList(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute3.Lore1"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute3.Lore2"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute3.Lore3"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute3.Lore4")));
		permmuteItem3.setItemMeta(permmuteMeta3);
		punishInv.setItem(22, permmuteItem3);
		//PermMute4
		ItemStack permmuteItem4 = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
		ItemMeta permmuteMeta4 = permmuteItem4.getItemMeta();
		permmuteMeta4.setDisplayName(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute4.Name"));
		permmuteMeta4.setLore(Arrays.asList(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute4.Lore1"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute4.Lore2"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute4.Lore3"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute4.Lore4")));
		permmuteItem4.setItemMeta(permmuteMeta4);
		punishInv.setItem(23, permmuteItem4);
		//PermMute5
		ItemStack permmuteItem5 = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
		ItemMeta permmuteMeta5 = permmuteItem5.getItemMeta();
		permmuteMeta5.setDisplayName(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute5.Name"));
		permmuteMeta5.setLore(Arrays.asList(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute5.Lore1"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute5.Lore2"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute5.Lore3"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute5.Lore4")));
		permmuteItem5.setItemMeta(permmuteMeta5);
		punishInv.setItem(24, permmuteItem5);
		//PermMute6
		ItemStack permmuteItem6 = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
		ItemMeta permmuteMeta6 = permmuteItem6.getItemMeta();
		permmuteMeta6.setDisplayName(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute6.Name"));
		permmuteMeta6.setLore(Arrays.asList(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute6.Lore1"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute6.Lore2"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute6.Lore3"), ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute6.Lore4")));
		permmuteItem6.setItemMeta(permmuteMeta6);
		punishInv.setItem(25, permmuteItem6);
		//TempBan1
		ItemStack tempbanItem1 = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getData());
		ItemMeta tempbanMeta1 = tempbanItem1.getItemMeta();
		tempbanMeta1.setDisplayName(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan1.Name"));
		tempbanMeta1.setLore(Arrays.asList(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan1.Lore1"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan1.Lore2"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan1.Lore3"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan1.Lore4")));
		tempbanItem1.setItemMeta(tempbanMeta1);
		punishInv.setItem(38, tempbanItem1);
		//TempBan2
		ItemStack tempbanItem2 = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getData());
		ItemMeta tempbanMeta2 = tempbanItem2.getItemMeta();
		tempbanMeta2.setDisplayName(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan2.Name"));
		tempbanMeta2.setLore(Arrays.asList(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan2.Lore1"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan2.Lore2"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan2.Lore3"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan2.Lore4")));
		tempbanItem2.setItemMeta(tempbanMeta2);
		punishInv.setItem(39, tempbanItem2);
		//TempBan3
		ItemStack tempbanItem3 = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getData());
		ItemMeta tempbanMeta3 = tempbanItem3.getItemMeta();
		tempbanMeta3.setDisplayName(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan3.Name"));
		tempbanMeta3.setLore(Arrays.asList(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan3.Lore1"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan3.Lore2"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan3.Lore3"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan3.Lore4")));
		tempbanItem3.setItemMeta(tempbanMeta3);
		punishInv.setItem(40, tempbanItem3);
		//TempBan4
		ItemStack tempbanItem4 = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getData());
		ItemMeta tempbanMeta4 = tempbanItem4.getItemMeta();
		tempbanMeta4.setDisplayName(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan4.Name"));
		tempbanMeta4.setLore(Arrays.asList(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan4.Lore1"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan4.Lore2"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan4.Lore3"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan4.Lore4")));
		tempbanItem4.setItemMeta(tempbanMeta4);
		punishInv.setItem(41, tempbanItem4);
		//TempBan5
		ItemStack tempbanItem5 = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getData());
		ItemMeta tempbanMeta5 = tempbanItem5.getItemMeta();
		tempbanMeta5.setDisplayName(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan5.Name"));
		tempbanMeta5.setLore(Arrays.asList(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan5.Lore1"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan5.Lore2"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan5.Lore3"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan5.Lore4")));
		tempbanItem5.setItemMeta(tempbanMeta5);
		punishInv.setItem(42, tempbanItem5);
		//TempBan6
		ItemStack tempbanItem6 = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getData());
		ItemMeta tempbanMeta6 = tempbanItem6.getItemMeta();
		tempbanMeta6.setDisplayName(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan6.Name"));
		tempbanMeta6.setLore(Arrays.asList(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan6.Lore1"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan6.Lore2"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan6.Lore3"), ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan6.Lore4")));
		tempbanItem6.setItemMeta(tempbanMeta6);
		punishInv.setItem(43, tempbanItem6);
		//PermBan1
		ItemStack permbanItem1 = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
		ItemMeta permbanMeta1 = permbanItem1.getItemMeta();
		permbanMeta1.setDisplayName(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan1.Name"));
		permbanMeta1.setLore(Arrays.asList(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan1.Lore1"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan1.Lore2"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan1.Lore3"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan1.Lore4")));
		permbanItem1.setItemMeta(permbanMeta1);
		punishInv.setItem(56, permbanItem1);
		//PermBan2
		ItemStack permbanItem2 = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
		ItemMeta permbanMeta2 = permbanItem2.getItemMeta();
		permbanMeta2.setDisplayName(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan2.Name"));
		permbanMeta2.setLore(Arrays.asList(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan2.Lore1"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan2.Lore2"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan2.Lore3"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan2.Lore4")));
		permbanItem2.setItemMeta(permbanMeta2);
		punishInv.setItem(57, permbanItem2);
		//PermBan3
		ItemStack permbanItem3 = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
		ItemMeta permbanMeta3 = permbanItem3.getItemMeta();
		permbanMeta3.setDisplayName(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan3.Name"));
		permbanMeta3.setLore(Arrays.asList(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan3.Lore1"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan3.Lore2"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan3.Lore3"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan3.Lore4")));
		permbanItem3.setItemMeta(permbanMeta3);
		punishInv.setItem(58, permbanItem3);
		//PermBan4
		ItemStack permbanItem4 = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
		ItemMeta permbanMeta4 = permbanItem4.getItemMeta();
		permbanMeta4.setDisplayName(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan4.Name"));
		permbanMeta4.setLore(Arrays.asList(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan4.Lore1"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan4.Lore2"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan4.Lore3"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan4.Lore4")));
		permbanItem4.setItemMeta(permbanMeta4);
		punishInv.setItem(59, permbanItem4);
		//PermBan5
		ItemStack permbanItem5 = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
		ItemMeta permbanMeta5 = permbanItem5.getItemMeta();
		permbanMeta5.setDisplayName(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan5.Name"));
		permbanMeta5.setLore(Arrays.asList(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan5.Lore1"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan5.Lore2"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan5.Lore3"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan5.Lore4")));
		permbanItem5.setItemMeta(permbanMeta5);
		punishInv.setItem(60, permbanItem5);
		//PermBan6
		ItemStack permbanItem6 = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
		ItemMeta permbanMeta6 = permbanItem6.getItemMeta();
		permbanMeta6.setDisplayName(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan6.Name"));
		permbanMeta6.setLore(Arrays.asList(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan6.Lore1"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan6.Lore2"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan6.Lore3"), ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan6.Lore4")));
		permbanItem6.setItemMeta(permbanMeta6);
		punishInv.setItem(61, permbanItem6);
		//Glass
		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
		ItemMeta glassMeta = glass.getItemMeta();
		glassMeta.setDisplayName(ChatColor.BLACK + "[" + ChatColor.RED + "jtPunish" + ChatColor.BLACK + "]");
		glass.setItemMeta(glassMeta);
		punishInv.setItem(1, glass);
		punishInv.setItem(8, glass);
		punishInv.setItem(9, glass);
		punishInv.setItem(10, glass);
		punishInv.setItem(11, glass);
		punishInv.setItem(12, glass);
		punishInv.setItem(13, glass);
		punishInv.setItem(14, glass);
		punishInv.setItem(15, glass);
		punishInv.setItem(16, glass);
		punishInv.setItem(17, glass);
		punishInv.setItem(19, glass);
		punishInv.setItem(26, glass);
		punishInv.setItem(27, glass);
		punishInv.setItem(28, glass);
		punishInv.setItem(29, glass);
		punishInv.setItem(30, glass);
		punishInv.setItem(31, glass);
		punishInv.setItem(32, glass);
		punishInv.setItem(33, glass);
		punishInv.setItem(34, glass);
		punishInv.setItem(35, glass);
		punishInv.setItem(37, glass);
		punishInv.setItem(44, glass);
		punishInv.setItem(45, glass);
		punishInv.setItem(46, glass);
		punishInv.setItem(47, glass);
		punishInv.setItem(48, glass);
		punishInv.setItem(49, glass);
		punishInv.setItem(50, glass);
		punishInv.setItem(51, glass);
		punishInv.setItem(52, glass);
		punishInv.setItem(53, glass);
		punishInv.setItem(55, glass);
		punishInv.setItem(62, glass);
		punishInv.setItem(63, glass);
		punishInv.setItem(64, glass);
		punishInv.setItem(65, glass);
		punishInv.setItem(69, glass);
		punishInv.setItem(70, glass);
		punishInv.setItem(71, glass);
		((HumanEntity) sender).openInventory(punishInv);
		return true;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void jtPunishInv(InventoryClickEvent e){
		if (e.getInventory() == null) {
			return;
		}
		if (e.getWhoClicked() == null) {
			return;
		}
		if (!(e.getWhoClicked() instanceof Player)) {
			return;
		}
		if (e.getCurrentItem() == null) {
			return;
		}
		if (e.getCurrentItem().getItemMeta() == null) {
			return;
		}
		if (!e.getCurrentItem().hasItemMeta()) {
			return;
		}	
		if(e.getCurrentItem().getItemMeta().getDisplayName() == null){
			return;
		}
		//First Offence
		ItemStack firstItem = new ItemStack(351, 1, (short) 10);
		ItemMeta firstMeta = firstItem.getItemMeta();
		firstMeta.setDisplayName(ChatColor.GREEN + "First Offence");
		firstItem.setItemMeta(firstMeta);
		//Second Offence
		ItemStack secondItem = new ItemStack(351, 1, (short) 14);
		ItemMeta secondtMeta = secondItem.getItemMeta();
		secondtMeta.setDisplayName(ChatColor.GOLD + "Second Offence");
		secondItem.setItemMeta(secondtMeta);
		//Third Offence
		ItemStack thirdItem = new ItemStack(351, 1, (short) 1);
		ItemMeta thirdtMeta = thirdItem.getItemMeta();
		thirdtMeta.setDisplayName(ChatColor.RED + "Third Offence");
		thirdItem.setItemMeta(thirdtMeta);
		//Sender
		Player player = (Player)e.getWhoClicked();
		//Ban Items
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute.Name")) || e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute.Name")) || e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan.Name")) || e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan.Name")) || e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLACK + "[" + ChatColor.RED + "jtPunish" + ChatColor.BLACK + "]") || e.getCurrentItem().getType() == Material.SKULL_ITEM) {
			e.setCancelled(true);
			return;
		}
		//Exit
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Exit")) {
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//First Offence
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "First Offence")) {
			player.sendMessage(ChatColor.BLACK + "[" + ChatColor.RED + "jtPunish" + ChatColor.BLACK + "] " + ChatColor.RED + "Offence has been set to Second Offence.");
			e.setCurrentItem(secondItem);
			e.setCancelled(true);
			return;
		}
		//Second Offence
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Second Offence")) {
			player.sendMessage(ChatColor.BLACK + "[" + ChatColor.RED + "jtPunish" + ChatColor.BLACK + "] " + ChatColor.RED + "Offence has been set to Third Offence.");
			e.setCurrentItem(thirdItem);
			e.setCancelled(true);
			return;
		}
		//Third Offence
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Third Offence")) {
			player.sendMessage(ChatColor.BLACK + "[" + ChatColor.RED + "jtPunish" + ChatColor.BLACK + "] " + ChatColor.RED + "Offence has been set to First Offence.");
			e.setCurrentItem(firstItem);
			e.setCancelled(true);
			return;
		}
		//TempMute1
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute1.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute1.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute1.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute1.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute1.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute1.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute1.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute1.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute1.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute1.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute1.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute1.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//TempMute2
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute2.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute2.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute2.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute2.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute2.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute2.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute2.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute2.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute2.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute2.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute2.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute2.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//TempMute3
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute3.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute3.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute3.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute3.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute3.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute3.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute3.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute3.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute3.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute3.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute3.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute3.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//TempMute4
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute4.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute4.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute4.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute4.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute4.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute4.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute4.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute4.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute4.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute4.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute4.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute4.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//TempMute5
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute5.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute5.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute5.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute5.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute5.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute5.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute5.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute5.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute5.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute5.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute5.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute5.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//TempMute6
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute6.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute6.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute6.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute6.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute6.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute6.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute6.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute6.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + jtPunish.getInstance().getConfig().getString("TempMute6.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempMute6.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempMute6.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempMute6.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermMute1
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute1.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermMute1.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("PermMute1.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermMute2
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute2.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermMute2.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("PermMute2.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermMute3
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute3.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermMute3.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("PermMute3.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermMute4
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute4.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermMute4.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("PermMute4.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermMute5
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute5.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermMute5.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("PermMute5.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermMute6
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + jtPunish.getInstance().getConfig().getString("PermMute6.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermMute6.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("PermMute6.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//TempBan1
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan1.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan1.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan1.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan1.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan1.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan1.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan1.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan1.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan1.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan1.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan1.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan1.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//TempBan2
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan2.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan2.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan2.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan2.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan2.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan2.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan2.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan2.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan2.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan2.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan2.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan2.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//TempBan3
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan3.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan3.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan3.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan3.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan3.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan3.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan3.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan3.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan3.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan3.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan3.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan3.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//TempBan4
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan4.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan4.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan4.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan4.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan4.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan4.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan4.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan4.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan4.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan4.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan4.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan4.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//TempBan5
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan5.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan5.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan5.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan5.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan5.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan5.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan5.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan5.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan5.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan5.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan5.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan5.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//TempBan6
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan6.Name")) && e.getInventory().contains(firstItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan6.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan6.Offence1Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan6.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan6.Name")) && e.getInventory().contains(secondItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan6.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan6.Offence2Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan6.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + jtPunish.getInstance().getConfig().getString("TempBan6.Name")) && e.getInventory().contains(thirdItem)) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("TempBan6.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("TempBan6.Offence3Duratian") + " " + jtPunish.getInstance().getConfig().getString("TempBan6.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermBan1
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan1.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermBan1.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName()  + " " + jtPunish.getInstance().getConfig().getString("PermBan1.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermBan2
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan2.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermBan2.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("PermBan2.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermBan3
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan3.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermBan3.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("PermBan3.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermBan4
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan4.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermBan4.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("PermBan4.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermBan5
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan5.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermBan5.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("PermBan5.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		//PermBan6
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + jtPunish.getInstance().getConfig().getString("PermBan6.Name"))) {
			player.performCommand(jtPunish.getInstance().getConfig().getString("PermBan6.Command") + " " + e.getInventory().getItem(66).getItemMeta().getDisplayName() + " " + jtPunish.getInstance().getConfig().getString("PermBan6.Reason"));
			e.setCancelled(true);
			player.closeInventory();
			return;
		}	
	}
}