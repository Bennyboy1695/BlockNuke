package me.Blackace.BlockNuke.Commands;

import me.Blackace.BlockNuke.BlockNuke;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandGetBlock implements CommandExecutor {

	BlockNuke plugin;

	public CommandGetBlock(BlockNuke i)
	{
		plugin = i;
	}

//Explain: /getblock world x y z

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(label.equalsIgnoreCase("getblock"))
		{
			if(sender.isOp())
			{
				if(args.length == 4)
				{
					World world = Bukkit.getServer().getWorld(args[0]);
					if(world == null)
					{
						sender.sendMessage(ChatColor.RED + "That world does not exist!");
						return false;
					}
					double x;
					double y;
					double z;
					try
					{
						x = Integer.parseInt(args[1]);
						y = Integer.parseInt(args[2]);
						z = Integer.parseInt(args[3]);
					}
					catch(Exception e)
					{
						sender.sendMessage("Illegal Arguement, x y and z must be integer values.");
						return false;
					}
					
					Location location = new Location(world, x, y, z);
					
					Block block = world.getBlockAt(location);
					
					sender.sendMessage(ChatColor.GOLD + "The block in world " + ChatColor.DARK_AQUA + world.getName() + ChatColor.GOLD + " at "+ ChatColor.AQUA + x + " " + y 
							+ " " + z + ChatColor.GOLD + " " + ChatColor.GREEN +  block.getType().toString() + ":" + block.getData());
					



				}

			}
		}

		return false;
	}

}
