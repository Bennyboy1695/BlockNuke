package me.Blackace.BlockNuke.Commands;

import me.Blackace.BlockNuke.BlockNuke;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDestroy implements CommandExecutor
{
	BlockNuke plugin;

	public CommandDestroy(BlockNuke instance)
	{
		plugin = instance;
	}


//Explain: /getblock world x y z
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {


		if(commandLabel.equalsIgnoreCase("worldname"))
		{

			Player player = (Player) sender;

			if(args.length == 0)
			{
				if(sender instanceof Player)
				{
					player.sendMessage(player.getWorld().getName());
				}
				else return false;
			}
			else return false;


		}


		if(commandLabel.equalsIgnoreCase("destroy"))
		{
			if(sender.isOp() == true)
			{
				if(args.length == 4)
				{
					World world = Bukkit.getServer().getWorld(args[0]);

					if(world == null)
					{
						sender.sendMessage(ChatColor.RED + "World does not exist or is not valid.");
						return false;
					}
					double x;
					double y;
					double z;
					try{
						x = Double.parseDouble(args[1]);
						y = Double.parseDouble(args[2]);
						z = Double.parseDouble(args[3]);
					}
					catch(NumberFormatException e)
					{
						sender.sendMessage(ChatColor.RED + "Invalid arguements. Co-ords must be given as numbers.");
						return false;
					}
					Location location = new Location(world, x, y, z);

					location.getChunk().load();

					if(location.getBlock().getType() != Material.AIR && location.getBlock() != null)
					{
						location.getBlock().setType(Material.AIR);
						sender.sendMessage(ChatColor.GREEN + "The block at " + x + " " + " " + y + " " + z + " has been destroyed.");
						return true;
					}
					else
					{
						sender.sendMessage(ChatColor.RED + "Block does not exist at that location or is not loaded.");
						return false;
					}
				}
				else
				{
					sender.sendMessage(ChatColor.RED + "Invalid arguements. <World name> <X> <Y> <Z>");
				}
			}
			else
			{
				sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return false;
			}
		}

		return true;
	}






}
