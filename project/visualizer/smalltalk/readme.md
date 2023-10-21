# Lauching image
Open the `Pharo11-vis-1.image` file using your install of Pharo executable/script.
You may have to delete the auto-generated `pharo-local` folder to open second time, no guaranteed.

# Set input file
A playground with code should be already opened from launching of the image. Example input JSON graphs are provided in the `input` folder. Copy their path and set `fileName` vairable at *line 2* with it **inside** the image.
Don't modify the `visualizer.st` file, it's merely for easy viewing in GitHub, it doesn't actually do anything.

# Running graph
Once image has been launched and input file has been set, click `Do it` button on the top left of the playground and the graph should automatically generate and open.
You can zoom in and out of the graph, and drag it around. The nodes (BLACK balls) should also be able to be dragged around.
When hovered over an edge(RED arrow), a popup message will indicate the text for it.