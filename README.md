BlockNuke
=========

A small plugin that simply adds commands for entity and block removal


Commands:

/destroy <world> <x> <y> <z> - Destroys the block at that given location. Essentially sets it to air. Works even on unloaded chunks.

/worldname - Gets the name of the current world your in.

/getblock <world> <x> <y> <z> - Gets the blocks type and metadata value at the given location. Useful so you know what your about to destroy.

/entitykill <world> <chunkX> <chunkZ> - Gets the chunk at the CHUNK location (differs from block location) and removes all entities in that chunk except players. ALL of them.
